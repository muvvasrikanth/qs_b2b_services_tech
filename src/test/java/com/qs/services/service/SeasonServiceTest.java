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

import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.SalesRep;
import com.qs.services.domain.SeasonList;
import com.qs.services.service.impl.SeasonServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class SeasonServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private SeasonService service = new SeasonServiceImpl() ;
	
	@Mock
	private SeasonDao dao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testGetSeasons() {
//		String salesRepId = "salesrep";
//		SeasonList expected = new SalesRep();
//		when(dao.getSeasons("salesrep")).thenReturn(expected) ;
//		SeasonList result = service.getSeasons(salesRepId);
//		assertEquals(expected, result);
//		verify(dao).getSeasons("salesrep");
	}

}
