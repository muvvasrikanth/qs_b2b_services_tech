package com.qs.services.service.impl;

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
		
		StringBuilder salesOrg = new StringBuilder();
		StringBuilder brand = new StringBuilder();
		StringBuilder channel = new StringBuilder();
		for (CustomerSalesArea csa : customerList.getCustomerSalesAreas()) {
			brand.append("'").append(csa.getBrand()).append("'").append(",");
			salesOrg.append("'").append(csa.getSalesOrg()).append("'").append(",");
			channel.append("'").append(csa.getDistributionChannel()).append("'").append(",");
		}

		return dao.getCatalogs(brand.substring(0, brand.length()-1), 
				salesOrg.substring(0, salesOrg.length()-1), channel.substring(0, channel.length()-1));
	}

	@Override
	public CatalogSearchCriteriaList getCatalogSearchCriteria(Integer catalogId) {
		return dao.getCatalogSearchCriterias(catalogId) ;
	}

}
