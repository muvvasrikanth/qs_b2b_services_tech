package com.qs.services.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.dao.SalesRepDao;
import com.qs.services.domain.SalesRep;
import com.qs.services.service.impl.ProfileServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private ProfileService service = new ProfileServiceImpl() ;
	
	@Mock
	private SalesRepDao dao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testGetProfile() {
		String salesRepId = "salesrep";
		SalesRep expected = new SalesRep();
		when(dao.getProfile("salesrep")).thenReturn(expected) ;
		SalesRep result = service.getSalesRep(salesRepId);
		assertEquals(expected, result);
		verify(dao).getProfile("salesrep");
	}

}
