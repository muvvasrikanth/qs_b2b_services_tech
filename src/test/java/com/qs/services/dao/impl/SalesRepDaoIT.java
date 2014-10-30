package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
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

import com.qs.services.dao.SalesRepDao;
import com.qs.services.domain.SalesRep;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SalesRepDaoIT extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesRepDaoIT.class) ;
	
	@Autowired
	private SalesRepDao dao ;

	@Test
	public void testAutowiring() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGet() throws JsonGenerationException, JsonMappingException, IOException{
		SalesRep rep = dao.getProfile("jay.lightburne@quiksilver.com") ;
		assertNotNull(rep) ;
		assertNotNull(rep.getId()) ;
		assertNotNull(rep.getFirstName()) ;
		assertEquals("JAY", rep.getFirstName()) ;
		assertEquals("LIGHTBURNE", rep.getLastName()) ;
		assertEquals("1002912", rep.getSalesRepId()) ;
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(rep));
	}
}
