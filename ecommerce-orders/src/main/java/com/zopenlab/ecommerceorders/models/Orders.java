package com.zopenlab.ecommerceorders.models;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zopenlab.ecommerceorders.beans.CustomerBean;

@Entity
public class Orders implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Customer is required")
	private Long customerid;
	
	@Transient
	private CustomerBean customer;
	
	@NotEmpty(message = "Choose one product at least")
	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
	private List<ProductItem> productItems;
	
	private Boolean isCompleted;
	
	public Orders() {
	}
	
	
	public Orders(Long customerid) {
		super();
		this.customerid = customerid;
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

	public CustomerBean getCustomerBean() {
		return customer;
	}

	public void setCustomerBean(CustomerBean customerBean) {
		this.customer = customerBean;
	}
	

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerid=" + customerid + ", customerBean=" + customer + ", productItems="
				+ productItems + ", isCompleted=" + isCompleted + "]";
	}


	
	
}
