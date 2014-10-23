package com.qs.services.dao.impl;

import static org.junit.Assert.assertNotNull;

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

import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.Season;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SeasonDaoImplIT extends AbstractJUnit4SpringContextTests {
	
	private static Logger logger = LoggerFactory.getLogger(SeasonDaoImplIT.class); 

	@Autowired
	private SeasonDao dao ;
	
	@Test
	public void test() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGetSeason() throws JsonGenerationException, JsonMappingException, IOException{
		String salesOrg = "1000", seasonId="151", collection="DA" ;
		Season season = dao.getSeason(salesOrg, seasonId, collection) ;
		assertNotNull(season) ;
		assertNotNull(season.getId()) ;
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(season));
	}
}