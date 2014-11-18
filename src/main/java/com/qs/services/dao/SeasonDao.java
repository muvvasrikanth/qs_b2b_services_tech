package com.qs.services.dao;

import java.util.List;

import com.qs.services.domain.Season;

public interface SeasonDao {
	
	public Season getSeason(String salesOrg, String seasonId, String collection) ;

	public List<String> getSeasonStatus(String salesOrg, String seasonId) ;
}
