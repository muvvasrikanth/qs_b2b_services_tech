package com.qs.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.domain.Catalog;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.service.CatalogService;
import com.qs.services.service.SecurityService;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CatalogControllerTest extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(CatalogControllerTest.class); 
	
	@InjectMocks
	private CatalogController controller = new CatalogController() ;
	
	@Mock
	private CatalogService catalogService ;
	
	@Mock
	private SecurityService securityService ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAutowiring() {
		logger.info("Testing autowiring");
		assertNotNull(controller) ;
	}

	@Test
	public void testGetCatalogs() throws Exception{
		CatalogList expected = new CatalogList();
		Catalog cat1 = new Catalog();
		cat1.setId(1);
		expected.getCatalogs().add(cat1);
		HttpServletRequest request = mock(HttpServletRequest.class);  
		HttpServletResponse response = new MockHttpServletResponse() ;
		when(request.getParameter("x-auth")).thenReturn("connect_user:password") ;
		when(catalogService.getCatalogs("salesrep")).thenReturn(expected) ;
		CatalogSearchCriteriaList cscl = new CatalogSearchCriteriaList();
		when(catalogService.getCatalogSearchCriteria(1)).thenReturn(cscl) ;
		
		CatalogList actual = controller.getCatalogs("salesrep", request, response);
		assertEquals(expected, actual) ;
		verify(securityService).authenticate("connect_user", "password") ;
		verify(catalogService).getCatalogs("salesrep");
		verify(catalogService).getCatalogSearchCriteria(1);
		assertEquals(cscl, cat1.GetCatalogSearchCriteriaList());
	}
}
