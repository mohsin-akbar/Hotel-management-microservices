package com.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
		
	public static void main(String[] args) {

		int x=10;
		String s="Mohsin";
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
