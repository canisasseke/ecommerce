package com.zopenlab.ecommercecustomers.web.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zopenlab.ecommercecustomers.dao.ICustomerDAO;
import com.zopenlab.ecommercecustomers.model.Customer;
import com.zopenlab.ecommercecustomers.web.exception.CustomerNotFoundException;

@RestController
public class CustomerRestController {

	@Autowired
	ICustomerDAO customerDAO;
	
	@GetMapping("/customers")
	@PreAuthorize("hasAnyAuthority('ROLE_READ_CUSTOMERS')")
	public List<Customer> getAllCustomers(){
		return customerDAO.findAll();
	}
	
	@GetMapping("/customers/{customerid}")
	@PreAuthorize("hasAnyAuthority('ROLE_READ_CUSTOMERS')")
	public Customer getCustomerById(@PathVariable Long customerid){
		Optional<Customer> optCustomer = customerDAO.findById(customerid);
		if(!optCustomer.isPresent()) throw new CustomerNotFoundException("this customer with id="+ customerid+" does not exist");
		return optCustomer.get();
	}
	
	@PostMapping("/customers")
	@PreAuthorize("hasAnyAuthority('ROLE_CREATE_CUSTOMERS')")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
		Customer customer1 = customerDAO.save(customer);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("{customerid}")
						.buildAndExpand(customer1.getId())
						.toUri();
		
		return ResponseEntity.created(location).body(customer1);
	}
	
	@PutMapping("/customers/{customerid}")
	@PreAuthorize("hasAnyAuthority('ROLE_UPDATE_CUSTOMERS')")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Long customerid) {
		Optional<Customer> optCustomer = customerDAO.findById(customerid);
		if(!optCustomer.isPresent()) throw new CustomerNotFoundException("this customer with id="+ customerid+" does not exist");
		customer.setId(customerid);
		Customer customer1 = customerDAO.save(customer);
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}
	@DeleteMapping("/customers/{customerid}")
	@PreAuthorize("hasAnyAuthority('ROLE_DELETE_CUSTOMERS')")
	public void deleteCustomer(Long customerid) {
		Optional<Customer> optCustomer = customerDAO.findById(customerid);
		if(!optCustomer.isPresent()) throw new CustomerNotFoundException("this customer with id="+ customerid+" does not exist");
		customerDAO.deleteById(customerid);
	}
	
}
