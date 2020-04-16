package com.zopenlab.ecommerceorders.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.zopenlab.ecommerceorders.beans.ProductBean;

@Entity
public class ProductItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "product id is required")
	private Long productid;
	
	@Transient
	private ProductBean product;
	
	@Min(value = 1, message = "the quantity must be at least one")
	private Integer quantity;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.EAGER)
	private Orders order;

	public ProductItem() {
		super();
	}

	public ProductItem(Long productid, Integer quantity, Orders order) {
		super();
		this.productid = productid;
		this.quantity = quantity;
		this.order = order;
	}

	public ProductItem( Long productid, Integer quantity) {
		super();
		this.productid = productid;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public ProductBean getProductBean() {
		return product;
	}

	public void setProductBean(ProductBean productBean) {
		this.product = productBean;
	}

	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", productid=" + productid + ", productBean=" + product + ", quantity="
				+ quantity + "]";
	}

	
}
