package com.zopenlab.ecommercecustomers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zopenlab.ecommercecustomers.model.Customer;

@Repository
public interface ICustomerDAO extends JpaRepository<Customer, Long>{

}
