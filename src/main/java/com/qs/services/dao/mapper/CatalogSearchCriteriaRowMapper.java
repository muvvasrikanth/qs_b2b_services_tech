package com.qs.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qs.services.domain.CatalogSearchCriteria;

public class CatalogSearchCriteriaRowMapper implements RowMapper<CatalogSearchCriteria> {

	@Override
	public CatalogSearchCriteria mapRow(ResultSet rs, int row)
			throws SQLException {
		CatalogSearchCriteria csc = new CatalogSearchCriteria() ;
		csc.setId(rs.getInt("ID"));
		csc.setCatalogueId(rs.getInt("CATALOGUEID"));
		csc.setSearchType(rs.getString("SEARCHTYPE"));
		csc.setSearchTypeCode(rs.getString("SEARCHTYPECODE"));
		csc.setSearchValueCode(rs.getString("SEARCHVALUECODE"));
		csc.setSearchValue(rs.getString("SEARCHVALUE"));
		csc.setCreatedBy(rs.getString("CREATEDBY"));
		csc.setCreatedDateTime(rs.getDate("CREATEDDATETIME"));
		csc.setModifiedBy(rs.getString("MODIFIEDBY"));
		csc.setModifiedDateTime(rs.getDate("MIDIFIEDDATETIME"));
		return csc ;
	}

}
