package com.zopenlab.ecommerceorders.models;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zopenlab.ecommerceorders.beans.CustomerBean;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "custom id can not be null")
	@NotEmpty(message = "custom id is rquired")
	private Long customerid;
	
	@Transient
	private CustomerBean customer;
	
	@NotEmpty(message = "Choose one product at leat")
	@OneToMany(mappedBy = "order")
	private Set<ProductItem> productItems;
	
	private Boolean isCompleted;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Long customerid, Set<ProductItem> productItems) {
		super();
		this.customerid = customerid;
		this.productItems = productItems;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	public Set<ProductItem> getProductItems() {
		return productItems;
	}
	public void setProductItems(Set<ProductItem> productItems) {
		this.productItems = productItems;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerid=" + customerid + ", productItems=" + productItems + ", isCompleted="
				+ isCompleted + "]";
	}

	
	
}
