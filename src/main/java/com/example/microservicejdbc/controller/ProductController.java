package com.example.microservicejdbc.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservicejdbc.config.PropertyConfig;
import com.example.microservicejdbc.model.Product;
import com.example.microservicejdbc.service.ProductService;

@RestController
@RequestMapping("/products")  //localhost:8080/products/
public class ProductController {

	//fields
	@Autowired
	private ProductService productService;
	@Autowired
	private PropertyConfig propertyConfig;
	@Autowired
	//this class will let us communicate using http
	//between microservices
	private RestTemplate restTemplate;
	
	
	//handler methods (ties web requests to internal web server methods)
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct (@RequestBody Product product){
		
		// to capture date-time right before send of product to db.
		LocalDateTime date = LocalDateTime.now();
		System.out.println(propertyConfig.getAddProductMsg());
		
		
	Product createdProduct =	productService.saveProduct(product);
	if(createdProduct !=null) {
	System.out.println("product" + createdProduct + "added successfully at " + date);
	}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createdProduct);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		//uses the service to retrieve the list of allProducts form DB.
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
//		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Optional<Product> optionalProduct = productService.getProductById(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
	    // Retrieve the product by ID
	    Optional<Product> optionalProduct = productService.getProductById(id);
	   
	    // Check if the product exists
	    if (optionalProduct.isPresent()) {
	        // Product exists, so delete it
	        productService.deleteProduct(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    } else {
	        // Product does not exist, return 404 Not Found
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
}
