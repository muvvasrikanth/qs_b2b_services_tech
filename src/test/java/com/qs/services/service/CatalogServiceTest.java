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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.SalesAreaList;
import com.qs.services.sao.SalesRepSao;
import com.qs.services.service.impl.CatalogServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CatalogServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CatalogService service = new CatalogServiceImpl() ;
	
	@Mock
	private CatalogDao dao ;
	
	@Mock
	private SalesRepSao salesRepSao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testGetCatalogs() throws Exception{
		CatalogList expected = new CatalogList();
		SalesAreaList sa = new SalesAreaList();
		when(dao.getCatalogs(sa)).thenReturn(expected) ;
		when(salesRepSao.getSalesAreas("salesrep")).thenReturn(sa) ;
		CatalogList result = service.getCatalogs("salesrep");
		
		assertEquals(expected, result);
		verify(dao).getCatalogs(sa);
		verify(salesRepSao).getSalesAreas("salesrep");
	}

}
