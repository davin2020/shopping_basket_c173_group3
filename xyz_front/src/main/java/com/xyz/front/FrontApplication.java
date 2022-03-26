package com.xyz.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FrontApplication {

	//get the value of the relevant backend api from the app.properties file
	@Value("${app.backend.urlportl}") 
	private static  String BACKEND_URL_PORT;
//	
////	spring.server.localurl
//	@Value("${server.port}") 
//	private static String localPort;
//	
//	@Value("${app.title}")
//	static String title;
	
//	@Autowired
//	private static Environment env;
//	//above is null
//
//	public String getAppProps() {
//	  return env.getProperty("spring.server.localurl");
//	}
	
    public static void main(String[] args) {

    	//run app first
        SpringApplication.run(FrontApplication.class, args);
        
//        System.out.println("__ Applicatoin URL = " + localUrl);
//    	System.out.println("__ Applicatoin PORT = " + localPort);
//    	
//    	final String BACKEND_URL_PORT = localUrl + ":" + localPort;
//    	
//    	System.out.println("__ title  = " + title);
    	//String x = env.getProperty("spring.server.localurl");
    	//System.out.println("__ URL  = " + x);
        
        System.out.println("main BACKEND_URL_PORT  = " + FrontApplication.BACKEND_URL_PORT);
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

