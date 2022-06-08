package com.engine.rule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engine.rule.model.Customer;
import com.engine.rule.model.Product;
import com.engine.rule.service.DiscountService;
import com.engine.rule.service.ProductService;

@RestController
@RequestMapping("/api")
public class DiscountController {
	
	@Autowired
	private DiscountService discountService;
	
	@PostMapping("/priceDiscount")
	public Customer getPriceDiscount(@RequestBody Customer customer) {
		Customer custPriceDiscount = discountService.getPriceDiscount(customer);
		System.out.println("custPriceDiscount == "+custPriceDiscount);
		return custPriceDiscount;
	}

}
