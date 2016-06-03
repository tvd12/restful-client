package com.tvd12.restful.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Support to builder a RestTemplate object
 * 
 * @author tavandung12
 *
 */
public class RestTemplateBuilder {

    // error handler
    private ResponseErrorHandler errorHandler 
            = new DefaultResponseErrorHandler();
    
    // list of request interceptor
    private List<ClientHttpRequestInterceptor> interceptors
            = new ArrayList<>();
    
    // list of message converter
    private List<HttpMessageConverter<?>> messageConverters
            = new ArrayList<>();
    
    // read response value timeout
    private int readTimeOut = 5 * 1000;
    
    // connection timeout
    private int connectTimeout = 5 * 1000;
    
    // reference of parent
    private RestCaller parent;
    
    // default constructor
    public RestTemplateBuilder() {}
    
    // construct wit reference of parent
    public RestTemplateBuilder(RestCaller parent) {
        this.parent = parent;
    }
    
    /**
     * Set the response value read timeout
     * 
     * @param timeOut the timeout
     * @return this pointer
     */
    public RestTemplateBuilder readTimeOut(int timeOut) {
        this.readTimeOut = timeOut;
        return this;
    }
    
    /**
     * Set the connection timeout
     * 
     * @param timeOut the timeout
     * @return this pointer
     */
    public RestTemplateBuilder connectTimeOut(int timeOut) {
        this.connectTimeout = timeOut;
        return this;
    }
    
    /**
     * Add a message converter to the list 
     * 
     * @param converter the message converter to add 
     * @return this pointer
     */
    public RestTemplateBuilder messageConverter(HttpMessageConverter<?> converter) {
        messageConverters.add(converter);
        return this;
    }
    
    /**
     * Add a request interceptor to the list
     * 
     * @param interceptor the interceptor to add
     * @return this pointer
     */
    public RestTemplateBuilder intercepter(ClientHttpRequestInterceptor interceptor) {
        interceptors.add(interceptor);
        return this;
    }
    
    /**
     * Set response error handler
     * 
     * @param errorHandler the error handler object
     * @return this pointer
     */
    public RestTemplateBuilder errorHandler(ResponseErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }
    
    /**
     * Back to parent
     * 
     * @return pointer of parent
     */
    public RestCaller done() {
        return parent;
    }
    
    /**
     * Check the message converter list, if its empty add a MappingJackson2HttpMessageConverter object to its
     */
    private void checkMessageConverters() {
        if(messageConverters.size() == 0)
            messageConverters.add(new MappingJackson2HttpMessageConverter());
    }
    
    /**
     * Build the RestTemplate object
     * 
     * @return the ResTemplate object
     */
    public RestTemplate build() {
        checkMessageConverters();
        RestTemplate template = new RestTemplate(clientHttpRequestFactory());
        template.setErrorHandler(errorHandler);
        template.setInterceptors(interceptors);
        template.getMessageConverters().addAll(messageConverters);
        return template;
    }
    
    /**
     * Create a ClientHttpRequestFactory object with timeout
     * 
     * @return the ClientHttpRequestFactory object
     */
    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = 
                new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(readTimeOut);
        factory.setConnectTimeout(connectTimeout);
        return factory;
    }
    
    
}
