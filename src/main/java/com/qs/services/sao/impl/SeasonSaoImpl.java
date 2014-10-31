package com.qs.services.sao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qs.services.domain.ItSAPPrebookSeasonList;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
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
	public SAPActiveSeasonProductList getActiveSeasonProducts(String salesRepId, SAPPrebookSeasonList seasons) throws JsonProcessingException {
		String url = config.getSapServiceUrl() + "/CONNECT_MOBILE/ActiveSeasnProd?sap-client=" + config.getSapClient() ;
		
		ItSAPPrebookSeasonList itSasonList = new ItSAPPrebookSeasonList();
		itSasonList.setSalesRep(salesRepId);
		for (SAPPrebookSeason season : seasons.getPrebookSeasons()) {
			itSasonList.addItPrebookActiveSeason(season.getSalesOrg(), season.getSeason(), season.getCollection());
		}
		ObjectMapper mapper = new ObjectMapper() ;
		String body = mapper.writeValueAsString(itSasonList) ;
		logger.info("Calling [ " + url + " ] with :: " + body);
		HttpEntity<String> httpEntity = new HttpEntity<String>(body, serviceUtil.createHeaders()) ;
		ResponseEntity<SAPActiveSeasonProductList> result = restTemplate.exchange(url,  HttpMethod.POST, httpEntity, SAPActiveSeasonProductList.class) ;
		return result.getBody();
	}
}
