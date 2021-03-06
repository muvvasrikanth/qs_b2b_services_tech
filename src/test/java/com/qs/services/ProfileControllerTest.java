package com.qs.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock ;

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

import com.qs.services.domain.SalesRep;
import com.qs.services.service.ProfileService;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(ProfileControllerTest.class); 
	
	@InjectMocks
	private ProfileController controller = new ProfileController() ;
	
	@Mock
	private ProfileService profileService ;
	
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
	public void testAuthenticate() throws Exception{
		SalesRep expected = new SalesRep();
		HttpServletRequest request = mock(HttpServletRequest.class); 
		HttpServletResponse response = new MockHttpServletResponse() ;
		when(request.getParameter("salesRepId")).thenReturn("salesRep@quiksilver.com") ;
		when(profileService.getSalesRep("salesRep@quiksilver.com")).thenReturn(expected) ;

		SalesRep actual = (SalesRep)controller.getProfile(request, response).getData();
		assertEquals(expected, actual) ;
		verify(profileService).getSalesRep("salesRep@quiksilver.com");
	}
}
