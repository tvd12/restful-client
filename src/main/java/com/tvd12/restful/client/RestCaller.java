package com.tvd12.restful.client;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T get(Class<T> clazz) {
        validateAll();
        URI uri = uriBuilder.build();
        RestTemplate template = templateBuilder.build();
        HttpEntity<?> entity = (entityBuilder != null)
                ? entityBuilder.build() : new HttpEntity<>(new HttpHeaders());
        return template.exchange(uri, HttpMethod.GET, entity, clazz)
                .getBody();
    }
    
    /**
     * Call restful user POST method and map value to an object
     * 
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T post(Class<T> clazz) {
        validateAll();
        URI uri = uriBuilder.build();
        RestTemplate template = templateBuilder.build();
        HttpEntity<?> entity = (entityBuilder != null)
                ? entityBuilder.build() : new HttpEntity<>(new HttpHeaders());
        return template.exchange(uri, HttpMethod.POST, entity, clazz)
                .getBody();
    }
    
    /**
     * Call restful user PUT method and map value to an object
     * 
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T put(Class<T> clazz) {
        validateAll();
        URI uri = uriBuilder.build();
        RestTemplate template = templateBuilder.build();
        HttpEntity<?> entity = (entityBuilder != null)
                ? entityBuilder.build() : new HttpEntity<>(new HttpHeaders());
        return template.exchange(uri, HttpMethod.PUT, entity, clazz)
                .getBody();
    }
    
    /**
     * Call restful user DELETE method and map value to an object
     * 
     * @param clazz class of the object to map
     * @return mapped object
     */
    public <T> T delete(Class<T> clazz) {
        validateAll();
        URI uri = uriBuilder.build();
        RestTemplate template = templateBuilder.build();
        HttpEntity<?> entity = (entityBuilder != null)
                ? entityBuilder.build() : new HttpEntity<>(new HttpHeaders());
        return template.exchange(uri, HttpMethod.DELETE, entity, clazz)
                .getBody();
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
    
}
