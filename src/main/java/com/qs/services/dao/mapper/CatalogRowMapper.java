package com.qs.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.qs.services.domain.Catalog;

public class CatalogRowMapper implements RowMapper<Catalog> {

	@Override
	public Catalog mapRow(ResultSet rs, int row) throws SQLException {
	
		Catalog cat = new Catalog() ;
		cat.setId(rs.getInt("ID"));
		cat.setName(rs.getString("NAME")) ;
		cat.setBrand(rs.getString("BRAND"));
		cat.setSalesOrg(rs.getString("SALESORG"));
		cat.setDistributionChannel(rs.getString("DISTCH"));
		cat.setLanguageCode(rs.getString("LANGUAGE_CODE"));
		cat.setValidFrom(rs.getDate("VALIDFROM"));
		cat.setValidTo(rs.getDate("VALIDTO"));
		cat.setType(rs.getString("TYPE"));
		cat.setNumberOfSearchCriteria(rs.getInt("NOOFSEARCHCRITERIA"));
		cat.setStatus(rs.getString("STATUS"));
		cat.setCreatedBy(rs.getString("CREATEDBY"));
		cat.setCreatedDateTime(rs.getDate("CREATEDDATETIME"));
		cat.setModifiedBy(rs.getString("MODIFIEDBY"));
		cat.setModifiedDateTime(rs.getDate("MODIFIEDDATETIME"));
		cat.setParentCatalogId(rs.getInt("PARENTCATALOGUEID"));
		cat.setLevel(rs.getInt("LEVEL"));
		cat.setImageUrl(rs.getString("IMAGEURL")) ;
		return cat ;
	}

}
