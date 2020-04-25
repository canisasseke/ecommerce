package com.zopenlab.ecommerceorders.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zopenlab.ecommerceorders.beans.ProductBean;

@FeignClient(name = "ecommerce-products")
@RibbonClient(name = "ecommerce-products")
public interface ProductServiceProxy {

	@GetMapping("/products/{productid}")
	public ProductBean getProductById(@PathVariable(name = "productid") Long productid);
}
