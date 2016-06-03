/**
 * 
 */
package com.tvd12.restful.client.testing;

import java.net.URI;

import org.testng.annotations.Test;

import com.tvd12.restful.client.HttpUriBuilder;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class HttpUriBuilderTest {

    @Test
    public void test() {
        URI uri = new HttpUriBuilder()
                .url("http://www.tvd12.com")
                .path("/users/{id}")
                .port(8080)
                .queryParam("page", 0)
                .queryParam("limit", 10)
                .variable("dungtv")
                .build();
        assertTrue(uri.toString().contains("http://www.tvd12.com:8080/users/dungtv"));
    }
    
}
