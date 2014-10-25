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
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.Season;
import com.qs.services.domain.SeasonList;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.impl.SeasonServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class SeasonServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private SeasonService service = new SeasonServiceImpl() ;
	
	@Mock
	private SeasonDao dao ;
	
	@Mock
	private SeasonSao sao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testGetSeasons() throws Exception {
		String salesRepId = "salesrep";
		SAPPrebookSeasonList preSeasonList = new SAPPrebookSeasonList();
		SAPPrebookSeason prebookSeason = new SAPPrebookSeason();
		prebookSeason.setSalesOrg("org");
		prebookSeason.setSeason("season");
		prebookSeason.setCollection("collection");
		preSeasonList.getPrebookSeasons().add(prebookSeason);
		
		SAPActiveSeasonProductList activeProductList = new SAPActiveSeasonProductList();
		
		when(sao.getRepPrebkSeasons("salesrep")).thenReturn(preSeasonList) ;
		when(sao.getActiveSeasonProducts(preSeasonList)).thenReturn(activeProductList) ;
		
		Season season = new Season();
		when(dao.getSeason("org", "season", "collection")).thenReturn(season) ;
		
		SeasonList result = service.getSeasons(salesRepId);
		assertEquals(season, result.getSeasons().get(0));
		assertEquals(activeProductList, result.getSeasonProducts());
		verify(sao).getRepPrebkSeasons("salesrep");
		verify(sao).getActiveSeasonProducts(preSeasonList);
		verify(dao).getSeason("org", "season", "collection");
	}
}
