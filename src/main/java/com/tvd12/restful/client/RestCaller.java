package com.tvd12.restful.client;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

/**
 * Support to call restful and map value to an object
 * 
 * @author tavandung12
 *
 */
public class RestCaller {

    // response of restful as string
    @Getter
    private String response;
    
    // URI builder
    private HttpUriBuilder uriBuilder;
    
    // HttpEntity builder
    private HttpEntityBuilder entityBuilder;
    
    // RestTemplate builder
    private RestTemplateBuilder templateBuilder;
    
    /**
     * Create new instance
     * 
     * @return an instance
     */
    public static RestCaller create() {
        return new RestCaller();
    }
    
    /**
     * Create a HttpUriBuilder object
     * 
     * @return the HttpUriBuilder object
     */
    public HttpUriBuilder uri() {
        uriBuilder = new HttpUriBuilder(this);
        return uriBuilder;
    }
    
    /**
     * Create HttpEntityBuilder object
     * 
     * @return the HttpEntityBuilder object
     */
    public HttpEntityBuilder entity() {
        entityBuilder = new HttpEntityBuilder(this);
        return entityBuilder;
    }
    
    /**
     * Create a RestTemplateBuilder object
     * 
     * @return the RestTemplateBuilder object
     */
    public RestTemplateBuilder template() {
        templateBuilder = new RestTemplateBuilder(this);
        return templateBuilder;
    }
    
    /**
     * Validate the uri builder
     * 
     * @throws IllegalStateException when the uri builder is null
     */
    protected void validateUriBuilder() {
        if(uriBuilder == null)
            throw new IllegalStateException("You must use uri() function to build a url");
    }
    
    /**
     * Validate the rest template builder object
     * 
     * @throws IllegalStateException when the builder object is null
     */
    protected void validateTemplate() {
        if(templateBuilder == null) 
            throw new IllegalStateException("You must use template function to build a rest template");
    }
    
    /**
     * Validate all builder objects
     */
    protected void validateAll() {
        validateUriBuilder();
        validateTemplate();
    }
    
    /**
     * Call restful user GET method and map value to an object
     * 
     * @param <T> the body type
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T get(Class<T> clazz) {
        return call(HttpMethod.GET, clazz);
    }
    
    /**
     * Call restful user POST method and map value to an object
     * 
     * @param <T> the body type
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T post(Class<T> clazz) {
        return call(HttpMethod.POST, clazz);
    }
    
    /**
     * Call restful user PUT method and map value to an object
     * 
     * @param <T> the body type
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T put(Class<T> clazz) {
       return call(HttpMethod.PUT, clazz);
    }
    
    /**
     * Call restful user DELETE method and map value to an object
     * 
     * @param <T> the body type
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T delete(Class<T> clazz) {
        return call(HttpMethod.DELETE, clazz);
    }
    
    private <T> T call(HttpMethod method, Class<T> clazz) {
        validateAll();
        URI uri = uriBuilder.build();
        RestTemplate template = templateBuilder.build();
        HttpEntity<?> entity = getHttpEntity();
        getLogger().debug("call {} from uri {} with entity {}", method, uri, entity);
        ResponseEntity<T> exchange = template.exchange(uri, method, entity, clazz);
        getLogger().debug("done {} from uri {} with result: \n{}\n", method, uri, exchange);
        return exchange.getBody();
    }
    
    private HttpEntity<?> getHttpEntity() {
        return (entityBuilder != null)
               ? entityBuilder.build() 
               : new HttpEntity<>(new HttpHeaders());
    }
    
    /**
     * Call restful user GET method and map value to string
     * 
     * @return this pointer
     */
    public RestCaller string() {
        response = get(String.class);
        return this;
    }
    
    /**
     * Convert (map) response in string value to an object
     * 
     * @param <T> the value type
     * @param clazz class of object to convert
     * @return mapped object
     */
    public <T> T convert(Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(response, clazz);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    
    private Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
    
}
