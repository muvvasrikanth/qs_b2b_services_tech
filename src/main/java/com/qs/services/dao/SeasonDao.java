package com.qs.services.dao;

import com.qs.services.domain.SeasonList;

public interface SeasonDao {
	
	public SeasonList getSeasonsBySalesRep(String salesRepId) ;

}
