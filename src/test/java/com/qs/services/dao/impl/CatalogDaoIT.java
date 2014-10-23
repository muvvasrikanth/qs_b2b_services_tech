package com.qs.services.dao.impl;

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
		String salesRepLoginId = "superadmin" ;
		CatalogList list = dao.getCatalogs(salesRepLoginId) ;
		assertNotNull(list) ;
		assertTrue(list.getCatalogs().size() > 0) ;
		logger.info("There are (" + list.getCatalogs().size() + ") catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(list)) ;
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
}
