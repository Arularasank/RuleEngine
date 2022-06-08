package com.engine.rule;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.engine.rule.config.DroolsBeanFactory;
import com.engine.rule.service.DiscountExcelIntegrationTest;

@SpringBootTest
class RulesEngineApplicationTests {
	
	@Test
	void contextLoads(){
		DiscountExcelIntegrationTest test = new DiscountExcelIntegrationTest();
	}

}
