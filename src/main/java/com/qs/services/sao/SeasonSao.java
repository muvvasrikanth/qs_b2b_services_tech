package com.qs.services.sao;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SalesRepBrandSeasons;

public interface SeasonSao {

	public SAPPrebookSeasonList getRepPrebkSeasons(String salesRepId) ;
	
	public SAPActiveSeasonProductList getActiveSeasonProducts(String salesRepId, SAPPrebookSeasonList seasons) throws JsonGenerationException, JsonMappingException, IOException ;
	
	public SAPActiveSeasonProductList getSeasonProducts(SalesRepBrandSeasons salesRepBrandSeasons) throws JsonProcessingException ;
	
}
