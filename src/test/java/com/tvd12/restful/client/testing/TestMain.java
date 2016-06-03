package com.tvd12.restful.client.testing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;

import com.tvd12.restful.client.RestCaller;

@SpringBootApplication
public class TestMain implements CommandLineRunner {

    private static String URL = "https://www.concursolutions.com/net2/oauth2/accesstoken.ashx";
    
    public static void main(String args[]) throws Exception {
        SpringApplication.run(TestMain.class);
        new TestMain().run();
    }
    
    @Override
    public void run(String... args) throws Exception {
        AccessTokenWrapper accessToken = RestCaller.create()
                .entity().header()
                    .accept(MediaType.APPLICATION_JSON)
                    .set("X-ConsumerKey", "yyJ1fA6wrs6oCLeirNPpwj")
                    .credential("Authorization", "ifprono3@gmail.com", "123456a@")
                    .contentType(MediaType.APPLICATION_JSON)
                    .done().done()
                .uri().url(URL).done()
                .template()
                    .connectTimeOut(3 * 1000)
                    .readTimeOut(3 * 1000)
                    .done()
                .get(AccessTokenWrapper.class);
        System.out.println(accessToken);
    }

}
