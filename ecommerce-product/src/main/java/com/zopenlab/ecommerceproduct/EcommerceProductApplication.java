package com.zopenlab.ecommerceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceProductApplication.class, args);
	}

}
