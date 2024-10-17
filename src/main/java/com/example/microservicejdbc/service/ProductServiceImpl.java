package com.example.microservicejdbc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicejdbc.dao.ProductRepository;
import com.example.microservicejdbc.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	// field
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		System.out.println(product);
		return productRepository.save(product);
	}
	
	@Override
	public Optional<Product> getProductById(Integer id) {
		// TODO Auto-generated method stub
		 return productRepository.findById(id);
	}
	
	@Override
	public List<Product> getAllProducts() {
		 return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
	}

	@Override
	public void deleteProduct(Integer id) {
		  productRepository.deleteById(id);
		
	}

	






}