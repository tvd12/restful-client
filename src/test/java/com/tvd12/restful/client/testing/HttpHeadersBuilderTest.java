/**
 * 
 */
package com.tvd12.restful.client.testing;

import org.testng.annotations.Test;

import com.tvd12.restful.client.HttpHeadersBuilder;

/**
 * @author tavandung12
 *
 */
public class HttpHeadersBuilderTest {

    @Test
    public void test() {
        new HttpHeadersBuilder()
            .set("a", "b")
            .set("a", "b")
            .build();
    }
    
}
