/**
 * 
 */
package com.tvd12.restful.client.testing;

import static com.tvd12.restful.client.testing.TestUtil.readExpected;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.lang.reflect.Field;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tvd12.restful.client.RestCaller;
import com.tvd12.restful.client.RestTemplateBuilder;

import lombok.Data;

/**
 * @author tavandung12
 *
 */
@ContextConfiguration(classes = {AppConfig.class})
public class RestCallerTest extends AbstractTestNGSpringContextTests {
    
    private static String URL = "http://www.tvd12.com";
    
    public RestCallerTest() {}
    
    @Test
    public void testGet1() throws Exception {
        String url = URL + "/token/access/get";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template()
                .connectTimeOut(3000)
                .readTimeOut(3000)
                .messageConverter(new MappingJackson2HttpMessageConverter())
                .errorHandler(new DefaultResponseErrorHandler());
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .get(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test
    public void testGet2() throws Exception {
        String url = URL + "/token/access/get";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .get(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    //=============== post =================
    @Test
    public void testPost1() throws Exception {
        String url = URL + "/token/access/post";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.POST))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .post(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test
    public void testPost2() throws Exception {
        String url = URL + "/token/access/post";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.POST))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .post(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
  //=============== put =================
    @Test
    public void testPut1() throws Exception {
        String url = URL + "/token/access/post";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.PUT))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .put(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test
    public void testPut2() throws Exception {
        String url = URL + "/token/access/put";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.PUT))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .put(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
  //=============== delete =================
    @Test
    public void testDelete1() throws Exception {
        String url = URL + "/token/access/delete";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.DELETE))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .delete(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test
    public void testDelete2() throws Exception {
        String url = URL + "/token/access/delete";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.DELETE))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .delete(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
  //=============== get as string =================
    @Test
    public void testGetAsString1() throws Exception {
        String url = URL + "/token/access/get";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        AccessTokenWrapper wrapper = 
                restTemplateBuilder.done()
                .string()
                .convert(AccessTokenWrapper.class);
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test
    public void testGetAsString2() throws Exception {
        String url = URL + "/token/access/get";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        String wrapper = 
                restTemplateBuilder.done()
                .string()
                .getResponse();
        server.verify();
        System.out.println(wrapper);
    }
    
    @Test(expectedExceptions = {IllegalStateException.class})
    public void testGetAsStringInvalidCase() throws Exception {
        String url = URL + "/token/access/get";
        RestTemplateBuilder restTemplateBuilder = 
                RestCaller.create()
                .entity().header()
                .accept(MediaType.APPLICATION_JSON)
                .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                .contentType(MediaType.APPLICATION_JSON)
                .done().done()
            .uri().url(url).done()    
                .template();
        RestTemplate restTemplate = new RestTemplate();
        restTemplateBuilder = spy(restTemplateBuilder);
        
        Field field = RestCaller.class.getDeclaredField("templateBuilder");
        field.setAccessible(true);
        field.set(restTemplateBuilder.done(), restTemplateBuilder);
        
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);
        server.expect(requestTo(url))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(readExpected("access_token.json"), MediaType.APPLICATION_JSON));
        restTemplateBuilder.done()
                .string()
                .convert(ClassA.class);
        server.verify();
    }
    
    @Test(expectedExceptions = {IllegalStateException.class})
    public void testInvalidCase1() {
        RestCaller.create().string();
    }
    
    @Test(expectedExceptions = {IllegalStateException.class})
    public void testInvalidCase2() {
        RestCaller.create()
            .uri().done()
            .string();
    }
    
    @Data
    @JsonIgnoreProperties
    public static class ClassA {
        private int a;
    }
}
