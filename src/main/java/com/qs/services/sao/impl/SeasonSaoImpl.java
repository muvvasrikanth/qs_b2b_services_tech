package com.qs.services.sao.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.sao.SeasonSao;
import com.qs.services.util.Config;
import com.qs.services.util.ServiceUtil;

@Component("SeasonSao")
public class SeasonSaoImpl implements SeasonSao {

	private static final Logger logger = LoggerFactory.getLogger(SeasonSaoImpl.class) ;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	@Autowired 
	private Config config ;
	
	@Autowired
	private ServiceUtil serviceUtil ;
	
	@Override
	public SAPPrebookSeasonList getRepPrebkSeasons(String salesRepId) {
		String url = config.getSapServiceUrl() + "/CONNECT_MOBILE/RepPrebkSeasons?sap-client=" + config.getSapClient() ;
		String body="{\"I_SALES_REP\":\"" + salesRepId + "\"}";
		logger.info("Calling [ " + url + " ] with :: " + body);
		HttpEntity<String> httpEntity = new HttpEntity<String>(body, serviceUtil.createHeaders()) ;
		ResponseEntity<SAPPrebookSeasonList> result = restTemplate.exchange(url,  HttpMethod.POST, httpEntity, SAPPrebookSeasonList.class) ;
		return result.getBody() ;
	}

	@Override
	public SAPActiveSeasonProductList getActiveSeasonProducts(SAPPrebookSeasonList seasons) throws JsonGenerationException, JsonMappingException, IOException {
		String url = config.getSapServiceUrl() + "/CONNECT_MOBILE/RepPrebkSeasons?sap-client=" + config.getSapClient() ;
		ObjectMapper mapper = new ObjectMapper() ;
		String body = mapper.writeValueAsString(seasons) ;
		logger.info("Calling [ " + url + " ] with :: " + body);
		HttpEntity<String> httpEntity = new HttpEntity<String>(body, serviceUtil.createHeaders()) ;
		ResponseEntity<SAPActiveSeasonProductList> result = restTemplate.exchange(url,  HttpMethod.POST, httpEntity, SAPActiveSeasonProductList.class) ;
		return result.getBody() ;	}
}
