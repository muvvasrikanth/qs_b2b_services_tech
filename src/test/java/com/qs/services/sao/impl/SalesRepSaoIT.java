package com.qs.services.sao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.domain.SalesAreaList;
import com.qs.services.sao.SalesRepSao;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SalesRepSaoIT extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesRepSaoIT.class) ;

	@Autowired
	private SalesRepSao sao ;
	
	@Test
	public void test() {
		assertNotNull(sao) ;
	}

	@Test
	public void getSalesAreasForSalesRep() throws JsonGenerationException, JsonMappingException, IOException{
		String salesRepId = "1002912" ;
		SalesAreaList salesAreaList = sao.getSalesAreas(salesRepId) ;
		assertNotNull(salesAreaList) ;
		assertTrue(salesAreaList.getSalesAreas().size() > 0) ;
		logger.info("\n\n" + new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(salesAreaList) + "\n\n");
	}
	
	@Test
	public void getSalesAreasForSalesRepEricGraciet() throws JsonGenerationException, JsonMappingException, IOException{
		String salesRepId = "1006782" ;
		SalesAreaList salesAreaList = sao.getSalesAreas(salesRepId) ;
		assertNotNull(salesAreaList) ;
		assertTrue(salesAreaList.getSalesAreas().size() > 0) ;
		logger.info("\n\n" + new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(salesAreaList) + "\n\n");
	}

}
