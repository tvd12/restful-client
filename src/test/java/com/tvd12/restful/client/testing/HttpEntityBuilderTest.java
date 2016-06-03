/**
 * 
 */
package com.tvd12.restful.client.testing;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import com.tvd12.restful.client.HttpEntityBuilder;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class HttpEntityBuilderTest {

    @Test
    public void test() {
        HttpEntity<String> entity = new HttpEntityBuilder()
                .body(new String("12345"))
                .header()
                    .accept(MediaType.ALL)
                    .allowCredential(true)
                    .charset(Charset.defaultCharset())
                    .contentType(MediaType.APPLICATION_JSON)
                    .credential("auth", "dungtv", "123456")
                    .method(HttpMethod.GET)
                    .set("accessToken", "12345678")
                    .done()
                .build();
        assertEquals(entity.getBody(), "12345");
        assertEquals(entity.getHeaders().getAccept().size(), 1);
        assertEquals(entity.getHeaders().getAcceptCharset().size(), 1);
        assertEquals(entity.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
        assertEquals(entity.getHeaders().get("accessToken").get(0), "12345678");
    }
    
    @Test
    public void test2() {
        new HttpEntityBuilder()
            .build();
    }
    
    @Test
    public void test3() {
        new HttpEntityBuilder()
            .header().done()
            .build();
    }
    
    @Test
    public void test5() {
        new HttpEntityBuilder()
            .body(new String("123"))
            .build();
    }
    
}
