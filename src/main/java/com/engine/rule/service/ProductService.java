package com.engine.rule.service;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.engine.rule.config.DroolsBeanFactory;
import com.engine.rule.model.Product;

@Service
public class ProductService {

	private KieSession kieSession = new DroolsBeanFactory().getKieSession();

	public Product applyLabelToProduct(Product product) {
		kieSession.insert(product);
		kieSession.fireAllRules();
		System.out.println(product.getLabel());
		return product;

	}

}
