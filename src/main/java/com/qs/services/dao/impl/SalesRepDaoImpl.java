package com.qs.services.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.qs.services.dao.SalesRepDao;
import com.qs.services.dao.mapper.SalesRepRowMapper;
import com.qs.services.domain.SalesRep;

@Component
public class SalesRepDaoImpl implements SalesRepDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SalesRepDaoImpl.class) ;

	@Autowired
	private DataSource dataSource ;
	
	@Autowired
	private JdbcTemplate template ;
	
	@Override
	public SalesRep getProfile(String salesRepLoginId) {
		String sql = "SELECT um.id, udm.first_name, udm.last_name, udm.country, " 
				+ "um.CURRENCY_CODE, um.CURRENCY_FORMAT, um.LANGUAGE_CODE, " 
				+ "um.date_format, udm.email FROM BGX_USER_MASTER AS um "
				+ "LEFT OUTER JOIN BGX_USER_DESC_MASTER AS udm ON udm.user_id "
				+ "= um.id WHERE um.loginid = '" + salesRepLoginId + "'" ;
		
		logger.info("Executing: " + sql);
		
		List<SalesRep> list = (List<SalesRep>) template.query(sql, new SalesRepRowMapper());
		
		if(list.size() != 1){
			throw new IllegalStateException("Incorrect number of records (" + list.size() + ") returned for " + salesRepLoginId + " should be (1)") ;
		} else {
			return list.get(0) ;
		}
	}

}
