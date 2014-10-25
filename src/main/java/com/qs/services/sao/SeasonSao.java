package com.qs.services.sao;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;

public interface SeasonSao {

	public SAPPrebookSeasonList getRepPrebkSeasons(String salesRepId) ;
	
	public SAPActiveSeasonProductList getActiveSeasonProducts(SAPPrebookSeasonList seasons) throws JsonGenerationException, JsonMappingException, IOException ;
	
}
