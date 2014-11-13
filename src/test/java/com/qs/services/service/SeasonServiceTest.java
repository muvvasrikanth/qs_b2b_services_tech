package com.qs.services.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.dao.ProductDao;
import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.BrandSeason;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SalesRepBrandSeasons;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.impl.SeasonServiceImpl;

@ContextConfiguration(locations = { "/test-context.xml" })
@RunWith(MockitoJUnitRunner.class)
public class SeasonServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private SeasonService service = new SeasonServiceImpl();

	@Mock
	private SeasonDao dao;

	@Mock
	private SeasonSao sao;

	@Mock
	private ProductDao productDao;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAutowiring() {
		assertNotNull(service);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetSeasons() throws Exception {
		String salesRepId = "salesrep";
		SAPPrebookSeasonList preSeasonList = new SAPPrebookSeasonList();
		SAPPrebookSeason prebookSeason = new SAPPrebookSeason();
		prebookSeason.setSalesOrg("org");
		prebookSeason.setSeason("season");
		prebookSeason.setCollection("collection");
		preSeasonList.getPrebookSeasons().add(prebookSeason);

		when(sao.getRepPrebkSeasons("salesrep")).thenReturn(preSeasonList);

		SAPPrebookSeasonList result = service.getSeasons(salesRepId) ;

		assertEquals(preSeasonList, result);
		verify(sao).getRepPrebkSeasons("salesrep");
	}
	
	@Test
	public void testGetProducts() throws JsonProcessingException, ParseException{
		SalesRepBrandSeasons mockSalesRepBrandSeasons = mockSalesRepBrandSeasons() ;
		SAPActiveSeasonProductList expectedProductList = new SAPActiveSeasonProductList();
		when(sao.getSeasonProducts(Mockito.any(SalesRepBrandSeasons.class))).thenReturn(expectedProductList ) ;
		SAPActiveSeasonProductList actualProductList = service.getSeasonProducts(mockSalesRepBrandSeasons) ;
		assertNotNull(actualProductList) ;
		verify(sao, Mockito.atLeastOnce()).getSeasonProducts(mockSalesRepBrandSeasons) ;
	}

	private SalesRepBrandSeasons mockSalesRepBrandSeasons() {
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep("1002912");
		srbs.setSince("20141001:000000");
		BrandSeason bs0 = new BrandSeason() ;
		bs0.setBrand("02");
		bs0.setSeason("151");
		srbs.getBrandSeasons().add(bs0) ;
		return srbs ;
	}

	private Map<String, String> mockUrlMap(){
		return null ;
	}

}
