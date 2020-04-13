package com.zopenlab.ecommerceproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zopenlab.ecommerceproduct.model.Product;

@Repository
public interface IProductDAO extends JpaRepository<Product, Long> {

}
