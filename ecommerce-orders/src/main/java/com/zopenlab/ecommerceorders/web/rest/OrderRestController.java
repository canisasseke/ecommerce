package com.zopenlab.ecommerceorders.web.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zopenlab.ecommerceorders.business.IHandleOrderBusiness;
import com.zopenlab.ecommerceorders.models.Orders;

@RestController
public class OrderRestController {

	@Autowired
	IHandleOrderBusiness handleOrderBusiness;
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return handleOrderBusiness.getAllOrders();
	}
	
	@GetMapping("/orders/{orderid}")
	public Orders getOrderById(@PathVariable(name = "orderid") Long orderid) {
		return handleOrderBusiness.getOrderById(orderid);
	}
		
	@GetMapping("/orders/{orderid}/details")
	public Orders getOrderDetailsById(@PathVariable(name = "orderid") Long orderid) {
		return handleOrderBusiness.getOrderWithDetailsById(orderid);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> createOrder(@Valid @RequestBody Orders order) {	
		Orders order1 = handleOrderBusiness.createOrder(order);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{orderid}")
				.buildAndExpand(order1.getId())
				.toUri();
		return ResponseEntity.created(location).body(order1);
	}
	
	@PutMapping("/orders/{orderid}")
	public ResponseEntity<Orders> updateOrder(@Valid @RequestBody Orders order, @PathVariable(name = "orderid") Long orderid) {		
		return new ResponseEntity<Orders>(handleOrderBusiness.updateOrder(order, orderid), HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{orderid}")
	public void deleteOrder(@PathVariable(name = "orderid") Long orderid) {
		handleOrderBusiness.deleteOrder(orderid);
	}
	
}
