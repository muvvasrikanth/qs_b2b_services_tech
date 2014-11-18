package com.qs.services.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.qs.services.dao.SeasonDao;
import com.qs.services.dao.mapper.SeasonRowMapper;
import com.qs.services.domain.Season;

@Component
public class SeasonDaoImpl implements SeasonDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonDaoImpl.class) ;
	
	@Autowired
	private JdbcTemplate template ;

	@Override
	public Season getSeason(String salesOrg, String seasonId, String collection) {
		String sql = "SELECT * FROM qs_season_master WHERE sales_org = '" + salesOrg + "' AND season_id = '" + seasonId + "' and collection = '" + collection + "'" ;
		logger.info("Executing: " + sql);
		
		List<Season> list = template.query(sql, new SeasonRowMapper()) ;

		if(null != list && list.size() != 1){
			throw new IllegalStateException("Incorrect number of seasons (" + list.size() + ") returned") ;
		} else {
			return list.get(0) ;
		}
	}

	@Override
	public List<String> getSeasonStatus(String salesOrg, String seasonId) {
		String sql = "SELECT status FROM qs_season_master WHERE sales_org=" + salesOrg + " AND season_id='" + seasonId + "'" ;
		logger.info("Executing: " + sql);
		List<String> statuses = (List<String>) template.query(sql, new StringRowMapper()) ;
		return statuses ;
	}
	
}

class StringRowMapper implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet rs, int i) throws SQLException {
		return rs.getString("STATUS") ;
	}
	
}
