package com.qs.services.sao.impl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.domain.SAPCustomer;
import com.qs.services.sao.CustomerSao;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerSaoIT extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerSaoIT.class) ;

	@Autowired
	private CustomerSao sao ;
	
	@Test
	public void testAutowiring() {
		assertNotNull(sao) ;
	}

	@Test
	public void testGetCustomerDetails() throws JsonGenerationException, JsonMappingException, IOException{
		String customerNumber = "1000044" ;
		
		SAPCustomer customer = sao.getCustomerDetails(customerNumber) ;
		
		assertNotNull(customer) ;
		assertNotNull(customer.getSoldToName()) ;
		
		logger.info(new ObjectMapper().writeValueAsString(customer));
		
	}
}
