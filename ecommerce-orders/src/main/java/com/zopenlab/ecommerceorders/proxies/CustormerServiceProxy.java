package com.zopenlab.ecommerceorders.proxies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zopenlab.ecommerceorders.beans.CustomerBean;



//@FeignClient(name = "ecommerce-customers")
public interface CustormerServiceProxy {

	@GetMapping("/customers/{customerid}")
	public CustomerBean getCustomerById(@PathVariable(name = "customerid") Long customerid);

}
