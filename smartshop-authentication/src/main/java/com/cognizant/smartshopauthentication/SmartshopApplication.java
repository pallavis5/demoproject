package com.cognizant.smartshopauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SmartshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmartshopApplication.class, args);
	}

}
