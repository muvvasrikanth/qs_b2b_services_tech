package com.qs.services.sao;

import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SeasonList;

public interface SeasonSao {

	public SAPPrebookSeasonList getRepPrebkSeasons(String salesRepId) ;
	
	public SAPActiveSeasonProductList getActiveSeasonProducts(SeasonList seasons) ;
	
}
