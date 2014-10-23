package com.qs.services.dao;

import com.qs.services.domain.Season;

public interface SeasonDao {
	
	public Season getSeason(String salesOrg, String seasonId, String collection) ;

}
