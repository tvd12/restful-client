package com.tvd12.restful.client;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 * Support to build a HttpHeaders object
 * 
 * @author tavandung12
 *
 */

public class HttpHeadersBuilder {

    // allow credential
    private boolean allowCredential = true;
    
    // media type of the body
    private MediaType contentType = MediaType.APPLICATION_JSON;
    
    //list of acceptable media types
    private List<MediaType> acceptedTypes = new ArrayList<>();
    
    //list of acceptable charsets
    private List<Charset> acceptedCharsets = new ArrayList<>();
    
    //the set of allowed HTTP methods
    private Set<HttpMethod> allowedMethods = new HashSet<>();
    
    //map of key-value of HTTP Headers
    private Map<String, List<String>> values = new HashMap<>();
    
    // reference of parent
    private HttpEntityBuilder parent;
    
    // default constructor
    public HttpHeadersBuilder() {}
    
    /**
     * construct with parent reference
     * @param parent reference of parent
     */
    public HttpHeadersBuilder(HttpEntityBuilder parent) {
        this.parent = parent;
    }
    
    /**
     * Add key-value to the map
     * 
     * @param name key
     * @param value value
     * @return this pointer
     */
    public HttpHeadersBuilder set(String name, String value) {
        if(!values.containsKey(name))
            values.put(name, new ArrayList<String>());
        values.get(name).add(value);
        return this;
    }
    
    /**
     * Set media type of the body
     * 
     * @param type media type of the body
     * @return this pointer
     */
    public HttpHeadersBuilder contentType(MediaType type) {
        this.contentType = type;
        return this;
    }
    
    /**
     * Add an acceptable media type to the list
     * 
     * @param type media type
     * @return this pointer
     */
    public HttpHeadersBuilder accept(MediaType type) {
        acceptedTypes.add(type);
        return this;
    }
    
    /**
     * Add acceptable charset to the list
     * 
     * @param charset charset
     * @return this pointer
     */
    public HttpHeadersBuilder charset(Charset charset) {
        acceptedCharsets.add(charset);
        return this;
    }
    
    /**
     * Set allow credential
     * 
     * @param allow allow or not
     * @return this pointer
     */
    public HttpHeadersBuilder allowCredential(boolean allow) {
        this.allowCredential = allow;
        return this;
    }
    
    /**
     * Create a credential from user name and password
     * 
     * @param name key mapped to credential value
     * @param username user name
     * @param password password
     * @return this pointer
     */
    public HttpHeadersBuilder credential(String name, String username, String password) {
        return set(name, "basic " + HttpUtil.credential(username, password));
    }
    
    /**
     * Add allowed HTTP method to the list
     * 
     * @param method the http method
     * @return this pointer
     */
    public HttpHeadersBuilder method(HttpMethod method) {
        allowedMethods.add(method);
        return this;
    }
    
    /**
     * Back to parent builder
     * 
     * @return pointer of parent
     */
    public HttpEntityBuilder done() {
        return parent;
    }
    
    /**
     * Build a HttpHeaders object
     * 
     * @return the HttpHeaders object
     */
    public HttpHeaders build() {
        HttpHeaders headers = new HttpHeaders();
        acceptedTypes.addAll(headers.getAccept());
        acceptedCharsets.addAll(headers.getAcceptCharset());
        allowedMethods.addAll(headers.getAllow());
        headers.putAll(values);
        headers.setAccept(acceptedTypes);
        headers.setContentType(contentType);
        headers.setAcceptCharset(acceptedCharsets);
        headers.setAllow(allowedMethods);
        headers.setAccessControlAllowCredentials(allowCredential);
        return headers;
    }
    
}
