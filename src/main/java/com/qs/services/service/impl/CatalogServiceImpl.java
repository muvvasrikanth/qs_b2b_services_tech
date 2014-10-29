package com.qs.services.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.CustomerList;
import com.qs.services.domain.CustomerSalesArea;
import com.qs.services.sao.CustomerSao;
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
	
	@Override
	public CatalogList getCatalogs(String salesRepId) {
		//use customer list to find out salesOrg/brand/channel/
		CustomerList customerList = customerSo.getCustomers(salesRepId);
		
		Set<String> brandSet = new HashSet<String>();
		Set<String> salesOrgSet = new HashSet<String>();
		Set<String> channelSet = new HashSet<String>();
		for (CustomerSalesArea csa : customerList.getCustomerSalesAreas()) {
			brandSet.add(csa.getBrand());
			salesOrgSet.add(csa.getSalesOrg());
			channelSet.add(csa.getDistributionChannel());
		}

		String brandParam = fromSet(brandSet);
		String salesOrgParam = fromSet(salesOrgSet);
		String channelParam = fromSet(channelSet);
		
		logger.info("Calling dao.getCatalogs() with (" + brandParam + ","
					+ salesOrgParam + "," + channelParam + ")" );
		
		return dao.getCatalogs(brandParam, salesOrgParam, channelParam);
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
