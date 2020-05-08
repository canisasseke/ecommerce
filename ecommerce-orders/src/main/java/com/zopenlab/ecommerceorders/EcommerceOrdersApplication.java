package com.zopenlab.ecommerceorders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.zopenlab.ecommerceorders.business.IHandleOrderBusiness;
import com.zopenlab.ecommerceorders.models.Orders;
import com.zopenlab.ecommerceorders.models.ProductItem;

@SpringBootApplication
//@EnableFeignClients
//@RibbonClients
@EnableDiscoveryClient
public class EcommerceOrdersApplication implements CommandLineRunner{

	@Autowired
	IHandleOrderBusiness handleOrderBusiness;
	
	 @LoadBalanced
	  @Bean
	  RestTemplate restTemplate() {
	      return new RestTemplate();
	  }
	 
	public static void main(String[] args) {
		SpringApplication.run(EcommerceOrdersApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		  Orders order = new Orders(); 
		  order.setCustomerid(1L);
		  List<ProductItem> items= new ArrayList<ProductItem>(); 
		  //ProductBean p1 = productServiceProxy.getProductById(1L); 
		  ProductItem pi1= new ProductItem(1L,10); //pi1.setOrder(order); 
		  ProductItem pi2= new ProductItem(2L,3); //pi2.setOrder(order); 
		  items.add(pi1); items.add(pi2);
		  order.setProductItems(items);
		  
		  handleOrderBusiness.createOrder(order);
		  handleOrderBusiness.getOrderById(1L).toString();
		 
		 // handleOrderBusiness.getOrderWithDetailsById(1L).toString();
		 
		
		
		
	}

}
