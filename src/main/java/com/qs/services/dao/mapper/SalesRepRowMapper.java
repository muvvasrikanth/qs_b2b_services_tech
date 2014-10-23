package com.qs.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qs.services.domain.SalesRep;

public class SalesRepRowMapper implements RowMapper<SalesRep> {

	@Override
	public SalesRep mapRow(ResultSet rs, int row) throws SQLException {
		SalesRep rep = new SalesRep() ;
		rep.setId(rs.getInt("id"));
		
		String fname = rs.getString("first_name") ;
		String lname = rs.getString("last_name") ;
		
		if(null != lname && lname.equals("*") && fname.contains(" ")){
			String[] nameParts = fname.split(" ") ;
			fname = nameParts[0] ;
			lname = nameParts[1] ;
		}
		
		rep.setFirstName(fname);
		rep.setLastName(lname);
		
		rep.setCountry(rs.getString("country"));
		rep.setCurrencyCode(rs.getString("currency_code"));
		rep.setCurrencyFormat(rs.getString("currency_format"));
		rep.setLanguageCode(rs.getString("language_code"));
		rep.setDateFormat(rs.getString("date_format"));
		rep.setEmail(rs.getString("email"));
		return rep ;
	}

}
