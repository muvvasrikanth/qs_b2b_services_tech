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
		return new SeasonList();
	}

}
