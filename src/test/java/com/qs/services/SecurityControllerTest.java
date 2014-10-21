package com.qs.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.service.SecurityService;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class SecurityControllerTest extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(SecurityControllerTest.class); 
	
	@InjectMocks
	private SecurityController controller = new SecurityController() ;
	
	@Mock
	private SecurityService service ;
	
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
	public void testAuthenticate(){
		HttpServletRequest request = mock(HttpServletRequest.class);  
		HttpServletResponse response = new MockHttpServletResponse() ;
		when(request.getPathInfo()).thenReturn("/authenticate") ;
		when(request.getParameter("x-auth")).thenReturn("connect_user:password") ;
		when(service.authenticate(Mockito.anyString(), Mockito.anyString())).thenReturn(Boolean.TRUE) ;
//		verify(service).authenticate(Mockito.anyString(), Mockito.anyString()) ;
		
		Boolean actual = controller.authenticate(request, response) ;
		assertNotNull(actual) ;
		assertTrue(actual) ;
	}
}
