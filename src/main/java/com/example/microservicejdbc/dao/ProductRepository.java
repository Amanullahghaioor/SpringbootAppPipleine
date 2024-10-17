package com.example.microservicejdbc.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.microservicejdbc.model.Product;

//SpringFramework will create a BEAN of this interface for us
public interface ProductRepository extends CrudRepository<Product, Integer>{

	
}
