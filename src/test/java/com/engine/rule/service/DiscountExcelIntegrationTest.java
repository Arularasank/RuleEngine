package com.engine.rule.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import com.engine.rule.config.DroolsBeanFactory;
import com.engine.rule.model.Customer;
import com.engine.rule.model.Customer.CustomerType;

public class DiscountExcelIntegrationTest {
	private KieSession kSession;

    @Before
    public void setup() {
        Resource resource = ResourceFactory.newClassPathResource("com/engine/rule/Discount.xls", getClass());
        kSession = new DroolsBeanFactory().getKieSession(resource);
    }

    @Test
    public void giveIndvidualLongStanding_whenFireRule_thenCorrectDiscount() throws Exception {
        Customer customer = new Customer(CustomerType.INDIVIDUAL, 5);
        kSession.insert(customer);
        kSession.fireAllRules();
        assertEquals(customer.getDiscount(), 15);
    }

    @Test
    public void giveIndvidualRecent_whenFireRule_thenCorrectDiscount() throws Exception {
        Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);
        kSession.insert(customer);
        kSession.fireAllRules();
        assertEquals(customer.getDiscount(), 5);
    }

    @Test
    public void giveBusinessAny_whenFireRule_thenCorrectDiscount() throws Exception {
        Customer customer = new Customer(CustomerType.BUSINESS, 0);
        kSession.insert(customer);
        kSession.fireAllRules();
        assertEquals(customer.getDiscount(), 20);
    }
}
