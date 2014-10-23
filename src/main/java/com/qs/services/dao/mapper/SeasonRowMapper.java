package com.qs.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.qs.services.domain.Season;

public class SeasonRowMapper implements RowMapper <Season> {

	@Override
	public Season mapRow(ResultSet rs, int row) throws SQLException {
		Season s = new Season() ;
		
		s.setId(rs.getInt("ID"));
		s.setSalesOrg(rs.getString("SALES_ORG"));
		s.setSeasonId(rs.getString("SEASON_ID"));
		s.setCollection(rs.getString("COLLECTION"));
		s.setTheme(rs.getString("THEME"));
		s.setDeliveryDateFrom(rs.getDate("DELIVERY_DATE_FROM"));
		s.setDeliveryDateTo(rs.getDate("DELIVERY_DATE_TO"));
		s.setOrderDateFrom(rs.getDate("ORDER_DATE_FROM"));
		s.setOrderDateTo(rs.getDate("ORDER_DATE_TO"));
		s.setApprovalNotes(rs.getString("APPROVAL_NOTES")) ;
		s.setApprovalStatus(rs.getString("APPROVAL_STATUS"));
		s.setStatus(rs.getString("STATUS"));
		s.setCreatedBy(rs.getString("CREATED_BY"));
		s.setCreatedDateTime(rs.getDate("CREATED_DATETIME"));
		s.setModifiedBy(rs.getString("MODIFIED_BY"));
		s.setModifiedDateTime(rs.getDate("MODIFIED_DATETIME"));
		s.setIsDefault(rs.getString("IS_DEFAULT"));
		s.setDefaultSeasonStartDate(rs.getDate("DEFAULT_SEASON_START_DATE"));
		
		return s ;
	}
}
