package com.qs.services.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.SAPActiveSeasonProductList;

public interface SeasonService {

	public SAPActiveSeasonProductList getSeasons(String salesRepId) throws JsonGenerationException, 
					JsonMappingException, IOException ;
	
}
