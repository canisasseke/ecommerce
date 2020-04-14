package com.zopenlab.ecommerceorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcommerceOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrdersApplication.class, args);
	}

}
