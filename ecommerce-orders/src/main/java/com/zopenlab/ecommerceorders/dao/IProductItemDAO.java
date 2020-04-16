package com.zopenlab.ecommerceorders.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zopenlab.ecommerceorders.models.ProductItem;

@Repository
public interface IProductItemDAO extends JpaRepository<ProductItem, Long>{

}
