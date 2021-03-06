package com.zopenlab.ecommerceproduct.web.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.zopenlab.ecommerceproduct.dao.IProductDAO;
import com.zopenlab.ecommerceproduct.exceptions.ProductNotFoundException;
import com.zopenlab.ecommerceproduct.model.Product;

@RestController
public class ProductrestController {
	
	@Autowired
	IProductDAO productDAO;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	@GetMapping("/products/{productid}")
	public Product getProductById(@PathVariable Long productid) {
		Optional<Product> optProduct = productDAO.findById(productid);
		if(!optProduct.isPresent()) throw new ProductNotFoundException("this product with id="+productid+" does not exist");
		return optProduct.get();
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		
		Product product1 = productDAO.save(product);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("{productid}")
						.buildAndExpand(product1.getId())
						.toUri();
		return ResponseEntity.created(location).body(product1);
	}
	
	@PutMapping("/products/{productid}")	
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product, @PathVariable Long productid) {
		Optional<Product> optProduct = productDAO.findById(productid);
		if(!optProduct.isPresent()) throw new ProductNotFoundException("this product with id="+productid+" does not exist");
		product.setId(productid);
		Product product1= productDAO.save(product);
		
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
		
	}
		
	@DeleteMapping("/products/{productid}")
	public void deleteProduct(Long productid) {
		Optional<Product> optProduct = productDAO.findById(productid);
		if(!optProduct.isPresent()) throw new ProductNotFoundException("this product with id="+productid+" does not exist");
		
		productDAO.deleteById(productid);
	}
	
}
