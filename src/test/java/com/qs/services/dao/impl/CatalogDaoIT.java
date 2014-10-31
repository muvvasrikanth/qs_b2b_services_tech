package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesArea;
import com.qs.services.domain.SalesAreaList;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogDaoIT extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private CatalogDao dao ;

	@Test
	public void testAutowiring() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGetCatalogs() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList list = dao.getCatalogs("01", "1000", "10") ;
		assertNotNull(list) ;
		assertTrue(list.getCatalogs().size() > 0) ;
		logger.info("There are (" + list.getCatalogs().size() + ") catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(list)) ;
	}
	
	@Test
	public void testGetCatalogsForSalesAreas() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList actual = dao.getCatalogs(mockSalesAreaList()) ;
		assertNotNull(actual) ;
		assertTrue(actual.getCatalogs().size() > 0) ;
		logger.info("There are (" + actual.getCatalogs().size() + " ) catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(actual));
	}
	
	@Test 
	public void testGetEmptyCatalogs() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList actual = new CatalogList() ;
		String actualJson = new ObjectMapper().writeValueAsString(actual) ;
		assertNotNull(actualJson) ;
		assertEquals("{\"catalogs\":[]}", actualJson) ;
		logger.info(actualJson) ;
	}
	
	@Test
	public void testGetCatalogCriteria() throws JsonGenerationException, JsonMappingException, IOException{
		Integer catalogId = 74 ;
		CatalogSearchCriteriaList criteriaList = dao.getCatalogSearchCriterias(catalogId) ;
		assertNotNull(criteriaList) ;
		assertTrue(criteriaList.getCatalogSearchCriterias().size() > 0) ;
		logger.info("There are (" + criteriaList.getCatalogSearchCriterias().size() + ") catalog search criteria in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(criteriaList));
	}
	
	private SalesAreaList mockSalesAreaList(){
		SalesAreaList list = new SalesAreaList() ;
		
		SalesArea sa0 = new SalesArea() ;
		sa0.setBrand("01");
		sa0.setSalesOrg("1000");
		sa0.setDistributionChannel("10");
		list.getSalesAreas().add(sa0) ;
		
		SalesArea sa1 = new SalesArea() ;
		sa1.setBrand("02");
		sa1.setSalesOrg("1030");
		sa1.setDistributionChannel("10");
		list.getSalesAreas().add(sa1) ;
		
		SalesArea sa2 = new SalesArea() ;
		sa2.setBrand("03");
		sa2.setSalesOrg("1030");
		sa2.setDistributionChannel("10");
		list.getSalesAreas().add(sa2) ;
		
		SalesArea sa3 = new SalesArea() ;
		sa3.setBrand("01");
		sa3.setSalesOrg("1050");
		sa3.setDistributionChannel("10");
		list.getSalesAreas().add(sa3) ;
		
		SalesArea sa4 = new SalesArea() ;
		sa4.setBrand("02");
		sa4.setSalesOrg("1050");
		sa4.setDistributionChannel("10");
		list.getSalesAreas().add(sa4) ;

		return list ;
	}
}
