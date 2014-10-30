package com.qs.services.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesAreaList;
import com.qs.services.sao.CustomerSao;
import com.qs.services.sao.SalesRepSao;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.CatalogService;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

	@Autowired
	private CatalogDao dao ;

	@Autowired
	private SeasonSao sao ;
	
	@Autowired
	private CustomerSao customerSo ;
	
	@Autowired
	private SalesRepSao salesRepSao ;
	
	@Override
	public CatalogList getCatalogs(String salesRepId) {
		SalesAreaList saList = salesRepSao.getSalesAreas(salesRepId) ;
		return dao.getCatalogs(saList) ;
	}
	
	private String fromSet(Set<String> set) {
		StringBuilder sb = new StringBuilder();
		for (String s : set) {
			sb.append("'").append(s).append("'").append(",");
		}
		if (sb.length()>0) {
			return sb.substring(0, sb.length()-1);
		}
		return "";
	}

	@Override
	public CatalogSearchCriteriaList getCatalogSearchCriteria(Integer catalogId) {
		return dao.getCatalogSearchCriterias(catalogId) ;
	}

}
