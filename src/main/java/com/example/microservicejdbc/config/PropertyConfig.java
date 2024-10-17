package com.example.microservicejdbc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PropertyConfig {
 
//fields
	@Value("${console.addproduct}")
	private String addProductMsg;

	public String getAddProductMsg() {
		return addProductMsg;
	}

	public void setAddProductMsg(String addProductMsg) {
		this.addProductMsg = addProductMsg;
	}
	
	
	
}
