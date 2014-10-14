package com.qs.services.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.sao.CustomerSao;
import com.qs.services.service.impl.CustomerServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CustomerService service = new CustomerServiceImpl() ;
	
	@Mock
	private CustomerSao sao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
//	@Test
//	public void testGetCustomers() {
//		fail("Not yet implemented");
//	}

}
