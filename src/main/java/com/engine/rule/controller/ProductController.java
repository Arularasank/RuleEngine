package com.engine.rule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engine.rule.model.Product;
import com.engine.rule.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Product getProduct(@RequestBody Product product) {
		Product productDetails = productService.applyLabelToProduct(product);
		System.out.println("product == "+productDetails);
		return productDetails;
	}

}
