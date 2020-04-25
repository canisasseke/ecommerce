package com.zopenlab.ecommercecustomers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.zopenlab.ecommercecustomers.dao.ICustomerDAO;
import com.zopenlab.ecommercecustomers.model.Customer;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceCustomersApplication implements CommandLineRunner{

	@Autowired
	ICustomerDAO customerDAO;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceCustomersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		customerDAO.save(new Customer("ASSEKE", "Canis", "canisasseke@gmail.com", "15 BP Abidjan 15 AEROPORT FHBA" , 
				LocalDate.of(1984, 12, 21)));
		customerDAO.save(new Customer("ODY", "Marina Nadege", "masseke@gmail.com", "15 BP Abidjan 15 AEROPORT FHBA" , 
				LocalDate.of(1986, 07, 02)));
		customerDAO.findAll().forEach(System.out::println);
		
	}


	
}
