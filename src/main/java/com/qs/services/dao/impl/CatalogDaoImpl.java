package com.qs.services.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.qs.services.dao.CatalogDao;
import com.qs.services.dao.mapper.CatalogRowMapper;
import com.qs.services.dao.mapper.CatalogSearchCriteriaRowMapper;
import com.qs.services.domain.Catalog;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteria;
import com.qs.services.domain.CatalogSearchCriteriaList;

@Component
public class CatalogDaoImpl implements CatalogDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class) ;
	
	@Autowired
	private DataSource dataSource ;
	
	@Autowired
	private JdbcTemplate template ;

	@Override
	public CatalogList getCatalogs() {
		String sql = "SELECT * FROM bgx_catalogue_master AS cm LEFT OUTER JOIN bgx_catalogue_desc_master AS cdm ON cdm.catalog_id = cm.id" ;
		logger.debug("Executing: " + sql);
		CatalogList list = new CatalogList() ;
		list.setCatalogs((List<Catalog>) template.query(sql, new CatalogRowMapper()));
		return list ;
	}

	@Override
	public CatalogSearchCriteriaList getCatalogSearchCriterias(Integer catalogId) {
		String sql = "SELECT * FROM bgx_catalogue_searchcriteria WHERE catalogueid = " + catalogId ;
		logger.debug("Executing: " + sql) ;
		CatalogSearchCriteriaList list = new CatalogSearchCriteriaList() ;
		list.setCatalogSearchCriterias((List<CatalogSearchCriteria>) template.query(sql, new CatalogSearchCriteriaRowMapper()));
		return list ;
	}

}
