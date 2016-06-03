package com.tvd12.restful.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.util.UriComponentsBuilder;

/**
 * Support to build an URI
 * 
 * @author tavandung12
 *
 */
public class HttpUriBuilder {

    // http url
    private String url;
    
    // path of url
    private String path;
    
    // port
    private int port;
    
    // values of path variables
    private List<Object> uriVariables
            = new ArrayList<>();
    
    // query parameters
    private Map<String, Object> queryParams
            = new HashMap<>();
    
    // reference of parent
    private RestCaller parent;
    
    // default constructor
    public HttpUriBuilder() {}
    
    // construct with reference of parent
    public HttpUriBuilder(RestCaller parent) {
        this.parent = parent;
    }
    
    /**
     * Set url
     * 
     * @param url url
     * @return this pointer
     */
    public HttpUriBuilder url(String url) {
        this.url = url;
        return this;
    }
    
    /**
     * Set path
     * 
     * @param path path
     * @return this pointer
     */
    public HttpUriBuilder path(String path) {
        this.path = path;
        return this;
    }
    
    /**
     * Set port
     * 
     * @param port port
     * @return this pointer
     */
    public HttpUriBuilder port(int port) {
        this.port = port;
        return this; 
    }
    
    /**
     * Add query parameter to the map
     * 
     * @param name name of query parameter
     * @param value value of query parameter
     * @return this pointer
     */
    public HttpUriBuilder queryParam(String name, Object value) {
        queryParams.put(name, value);
        return this;
    }
    
    /**
     * Add an value of a path variable to the list
     * 
     * @param value value of path variable
     * @return this pointer
     */
    public HttpUriBuilder variable(Object value) {
        uriVariables.add(value);
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
     * Build an URI
     * 
     * @return the uri
     */
    public URI build() {
        url = (path != null) ? url + path : url;
        UriComponentsBuilder uriComponentsBuilder =
                UriComponentsBuilder.fromHttpUrl(url);
        for(Entry<String, Object> param : queryParams.entrySet()) 
            uriComponentsBuilder.queryParam(param.getKey(), param.getValue());
        if(port > 0)
            uriComponentsBuilder.port(port);
        return uriComponentsBuilder
                .buildAndExpand(uriVariables.toArray())
                .encode()
                .toUri();
    }
    
}
