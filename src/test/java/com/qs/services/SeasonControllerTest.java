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

import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.service.SeasonService;
import com.qs.services.service.SecurityService;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class SeasonControllerTest extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(SeasonControllerTest.class); 
	
	@InjectMocks
	private SeasonController controller = new SeasonController() ;
	
	@Mock
	private SeasonService seasonService ;
	
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
	public void testGetSeasons() throws Exception{
		SAPPrebookSeasonList expected = new SAPPrebookSeasonList();
		HttpServletRequest request = mock(HttpServletRequest.class);  
		HttpServletResponse response = new MockHttpServletResponse() ;
		when(seasonService.getSeasons("salesrep")).thenReturn(expected) ;
//		when(request.getHeader("x-auth")).thenReturn("mobile_user:Quiksilver1") ;
		
		SAPPrebookSeasonList actual = (SAPPrebookSeasonList)controller
				.getSeasons("salesrep", request, response).getData();
		assertEquals(expected, actual) ;
		verify(seasonService).getSeasons("salesrep");
	}
}
