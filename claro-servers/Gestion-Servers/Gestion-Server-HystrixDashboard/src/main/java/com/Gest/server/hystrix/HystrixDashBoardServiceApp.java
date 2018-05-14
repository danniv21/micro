package com.Gest.server.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 *  
 * 
 * @author  
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardServiceApp {

	public static void main(String[] args) {

		SpringApplication.run(HystrixDashBoardServiceApp.class, args);

	}

}
