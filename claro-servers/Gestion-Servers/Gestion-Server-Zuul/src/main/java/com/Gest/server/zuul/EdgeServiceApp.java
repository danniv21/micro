package com.Gest.server.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 *  
 * 
 * @author  
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class EdgeServiceApp {

	public static void main(String[] args) {

		SpringApplication.run(EdgeServiceApp.class, args);

	}

//	@Bean
//	public PreFilter preFilter() {
//		return new PreFilter();
//	}
	

}
