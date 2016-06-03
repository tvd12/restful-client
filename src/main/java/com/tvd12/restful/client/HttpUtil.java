package com.tvd12.restful.client;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * Support to create a credential from user name and password
 * 
 * @author tavandung12
 *
 */
public class HttpUtil {

    // prevent new instance
    private HttpUtil() {}
    
    /**
     * Create a credential from user name and password
     * 
     * @param username user name
     * @param password password
     * @return a credential as base64 string
     */
    public static String credential(String username, String password) {
        return credential(username, password, "UTF-8");
    }

    /**
     * Create a credential from user name and password
     * 
     * @param username user name
     * @param password password
     * @param encoding encoding
     * @return a credential as base64 string
     */
    public static String credential(String username, String password, String encoding) {
        try {
            return new String(Base64.encodeBase64((username + ":" + password)
                    .getBytes(encoding)));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
    
}
