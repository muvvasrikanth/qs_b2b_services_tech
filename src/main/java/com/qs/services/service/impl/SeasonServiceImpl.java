package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.SeasonList;
import com.qs.services.service.SeasonService;

@Service("SeasonService")
public class SeasonServiceImpl implements SeasonService {
	
	@Autowired
	private SeasonDao dao ;

	@Override
	public SeasonList getSeasons(String salesRepId) {
//		return dao.getSeasons(salesRepId);
		
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
		return new SeasonList();
	}

}
