package com.engine.rule.service;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.engine.rule.config.DroolsBeanFactory;
import com.engine.rule.model.Customer;
import com.engine.rule.model.Product;

@Service
public class DiscountService {

	private KieSession kieSession = new DroolsBeanFactory().getKieSession();

	public Customer getPriceDiscount(Customer customer) {
		kieSession.insert(customer);
		kieSession.fireAllRules();
		System.out.println(customer.getDiscount());
		return customer;

	}

}
