package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

import com.qs.services.domain.CustomerList;
import com.qs.services.sao.CustomerSao;
import com.qs.services.sao.impl.CustomerSaoImpl;
import com.qs.services.util.Config;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CustomerSaoImplTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CustomerSao sao = new CustomerSaoImpl() ;
	
	@Mock
	private RestTemplate template ;
	
	@Mock
	private Config config ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(sao) ;
	}
	
	@Test
	public void testGetCustomers() {
		String salesRepId = "salesrep";
		CustomerList expected = new CustomerList();
		ResponseEntity<CustomerList> entity = new ResponseEntity<CustomerList>(expected, HttpStatus.OK);
		when(template.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), (HttpEntity)Mockito.any(), 
				Mockito.eq(CustomerList.class))).thenReturn(entity) ;
		CustomerList result = sao.getCustomers(salesRepId);
		assertEquals(expected, result);
	}

}
