package com.qs.services.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.Season;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.SeasonService;

@Service("SeasonService")
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonDao dao ;

	@Autowired
	private SeasonSao sao ;

	/*
	 * 
	 * How to get the seasons 
	 * 
	 * 1) Use the salesRepId from the sales rep profile to call SeasonSao.getRepPrebkSeasons(...)
	 * 
	 * This will get a list of prebook seasons for the sales rep
	 * 
	 * 2) Use the resulting list from (1) to call SeasonSao.getActiveSeasonProducts(...)
	 * 
	 * This will get a list of products for the seasons for the sales rep
	 * 
	 * 3) Use the resulting list from (1) to call SeasonDao.getSeason(...) with the sales_org, season_id and collection
	 * 
	 * This will get detail information about that season from the connect database
	 * 
	 * 
	 */
	@Override
	public SAPActiveSeasonProductList getSeasons(String salesRepId) throws JsonGenerationException, 
								JsonMappingException, IOException {
		SAPPrebookSeasonList prebookSeasons = sao.getRepPrebkSeasons(salesRepId);
		SAPActiveSeasonProductList activeSeasonProducts = sao.getActiveSeasonProducts(prebookSeasons);
		
		for (SAPPrebookSeason prebookSeason : prebookSeasons.getPrebookSeasons()) {
			Season season = dao.getSeason(prebookSeason.getSalesOrg(), prebookSeason.getSeason(), 
					prebookSeason.getCollection());
			activeSeasonProducts.getSeasons().add(season);
		}
		return activeSeasonProducts;
	}

}
