package com.example.microservicejdbc.service;

import java.util.List;
import java.util.Optional;

import com.example.microservicejdbc.model.Product;

public interface ProductService {

	 Product saveProduct(Product product);
    Optional<Product> getProductById(Integer id);
    List<Product> getAllProducts();
    void deleteProduct(Integer id);
	
	
	
}
