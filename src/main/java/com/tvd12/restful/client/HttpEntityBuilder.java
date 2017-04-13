package com.tvd12.restful.client;

import org.springframework.http.HttpEntity;

/**
 * Support to build HttpEntity object
 * 
 * @author tavandung12
 *
 */
public class HttpEntityBuilder {

    // the entity body
    private Object body;
    
    // the builder of HttpHeaders
    private HttpHeadersBuilder headersBuilder;
    
    // the parent
    private RestCaller parent;
    
    // default constructor
    public HttpEntityBuilder() {}
    
    // Construct with parent
    public HttpEntityBuilder(RestCaller parent) {
        this.parent = parent;
    }

    /**
     * Create a HttpHeaders builder
     * 
     * @return a HttpHeaders builder
     */
    public HttpHeadersBuilder header() {
        headersBuilder = new HttpHeadersBuilder(this);
        return headersBuilder;
    }
    
    /**
     * Set the entity body
     * 
     * @param body the entity body
     * @return this pointer
     */
    public HttpEntityBuilder body(Object body) {
        this.body = body;
        return this;
    }
    
    /**
     * Finish setting up properties and back to parent
     * 
     * @return parent reference
     */
    public RestCaller done() {
        return parent;
    }
    
    /**
     * Build HttpEntity object
     * 
     * @param <T> the body type
     * @return a HtttpEntity object
     */
    @SuppressWarnings("unchecked")
    public <T> HttpEntity<T> build() {
        if(headersBuilder != null && body != null) 
            return new HttpEntity<T>((T)body, headersBuilder.build());
        if(headersBuilder != null)
            return new HttpEntity<>(headersBuilder.build());
        if(body != null)
            return new HttpEntity<T>((T)body);
        return null;
    }
    
}
