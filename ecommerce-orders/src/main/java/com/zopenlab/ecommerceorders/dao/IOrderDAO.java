package com.zopenlab.ecommerceorders.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zopenlab.ecommerceorders.models.Orders;

@Repository
public interface IOrderDAO extends JpaRepository<Orders, Long>{

}
