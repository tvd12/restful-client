/**
 * 
 */
package com.tvd12.restful.client.testing;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.testng.annotations.Test;

import com.tvd12.restful.client.RestTemplateBuilder;

/**
 * @author tavandung12
 *
 */
public class RestTemplateBuilderTest {

    @Test
    public void test() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.intercepter(new BasicAuthInterceptor("dungtv", "123456"))
            .build();
    }
    
}

class BasicAuthInterceptor implements ClientHttpRequestInterceptor {

    private final String username;
    private final String password;

    public BasicAuthInterceptor( String username, String password ) {
        this.username = username;
        this.password = password;
    }

    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {

        //Build the auth-header
        final String auth = username + ":" + password;
        final byte[] encodedAuth = Base64.encodeBase64( auth.getBytes( Charset.forName( "US-ASCII" ) ) );
        final String authHeader = "Basic " + new String( encodedAuth );

        //Add the auth-header
        request.getHeaders().add( "Authorization", authHeader );

        return execution.execute( request, body );
    }

}
