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

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.service.impl.CatalogServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CatalogServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CatalogService service = new CatalogServiceImpl() ;
	
	@Mock
	private CatalogDao dao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testGetCatalogs() {
		String salesRepId = "salesrep";
		CatalogList expected = new CatalogList();
		when(dao.getCatalogs("salesrep")).thenReturn(expected) ;
		CatalogList result = service.getCatalogs(salesRepId);
		assertEquals(expected, result);
		verify(dao).getCatalogs("salesrep");
	}

}
