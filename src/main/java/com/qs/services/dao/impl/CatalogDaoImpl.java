package com.qs.services.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.qs.services.dao.CatalogDao;
import com.qs.services.dao.mapper.CatalogRowMapper;
import com.qs.services.dao.mapper.CatalogSearchCriteriaRowMapper;
import com.qs.services.domain.Catalog;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteria;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesArea;
import com.qs.services.domain.SalesAreaList;
import com.qs.services.sao.SalesRepSao;

@Component
public class CatalogDaoImpl implements CatalogDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class) ;
	
	@Autowired
	private SalesRepSao salesRepSao ;
	
//	@Autowired
//	@Qualifier(value="dataSource")
//	private DataSource dataSource ;
	
	@Autowired
	private JdbcTemplate template ;

	/**
	 * The getCatalogs() method calls the GET_CATALOGS stored procedure. The 
	 * stored procedure assumes the following parameters
	 * brand_id (a list of comma separated brand id's ie. "'01','02','03'" [brand's allowed for the sales rep]
	 * sales_org (a list of comma separated sales org's ie. "'1050','1030',..." [sales orgs for the sales rep]
	 * dist_ch (a list of distribution channels "'10','20',..." [distribution channels for the sales rep]
	 */
	@Override
	public CatalogList getCatalogs(String brandId, String salesOrg, String distCh) {		
		if(logger.isDebugEnabled()){logger.debug("Executing: GET_CATALOGS (brandId=" + brandId + " : salesOrg=" + salesOrg + " : distCh=" + distCh + ")" );}
		CatalogList list = new GetCatalogsSP(template).execute(brandId, salesOrg, distCh) ;
		return list ;
	}
	
	/**
	 * This getCatalogs() method takes a salesRepId and returns all of the
	 * catalogs for the sales areas in that list.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Override
	public CatalogList getCatalogs(SalesAreaList salesAreaList) throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList catalogList = new CatalogList() ;
		
		CatalogList list = null ;
		for(SalesArea sa : salesAreaList.getSalesAreas()){
			if(logger.isDebugEnabled()){logger.debug("Getting catalogs for (" + new ObjectMapper().writeValueAsString(sa));}
			list = new GetCatalogsSP(template).execute(sa.getBrand(), sa.getSalesOrg(), sa.getDistributionChannel()) ;
			if(list != null){
				catalogList.getCatalogs().addAll(list.getCatalogs()) ;
			}
		}
		
		return catalogList ;
	}

	@Override
	public List<Integer> getChildren(List<Integer> catalogIds, Integer catalogId){
		
		String sql = "SELECT id FROM BGX_CATALOGUE_MASTER WHERE parentcatalogueid = " + catalogId ;
		
		if(logger.isDebugEnabled()){logger.debug("Executing: " + sql);}
		
		List<Integer> list = (List<Integer>) template.query(sql, new IntegerMapper()) ;

		for(Integer i : list){
			if(logger.isDebugEnabled()){logger.debug(i.toString()) ;}
			if(! catalogIds.contains(i)){
				catalogIds.add(i) ;
			}
			getChildren(catalogIds, i) ;
		}
		
		return catalogIds ;
	}

	@Override
	public CatalogSearchCriteriaList getCatalogSearchCriterias(Integer catalogId) {
		String sql = "SELECT * FROM bgx_catalogue_searchcriteria WHERE catalogueid = " + catalogId ;
		if(logger.isDebugEnabled()){logger.debug("Executing: " + sql) ;}
		CatalogSearchCriteriaList list = new CatalogSearchCriteriaList() ;
		list.setCatalogSearchCriterias((List<CatalogSearchCriteria>) template.query(sql, new CatalogSearchCriteriaRowMapper()));
		return list ;
	}
}

class IntegerMapper implements RowMapper<Integer>{
	public Integer mapRow(ResultSet rs, int row) throws SQLException{
		return rs.getInt(1) ;
	}
}

class GetCatalogsSP extends StoredProcedure {
	protected GetCatalogsSP(){}
	
	@SuppressWarnings("rawtypes")
	protected GetCatalogsSP(JdbcTemplate template){
		super(template, "GET_CATALOGS") ;
		
		RowMapper mapper = new CatalogRowMapper() ;
		
		declareParameter(new SqlReturnResultSet("catalogs", mapper)) ;
		declareParameter(new SqlParameter("brand_id", Types.VARCHAR)) ;
		declareParameter(new SqlParameter("sales_org", Types.VARCHAR)) ;
		declareParameter(new SqlParameter("dist_ch", Types.VARCHAR)) ;
		
		compile() ;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CatalogList execute(String brandId, String salesOrg, String distCh){
		Map in = new HashMap() ;
		in.put("brand_id", brandId) ;
		in.put("sales_org", salesOrg) ;
		in.put("dist_ch", distCh) ;
		
		Map result = execute(in) ;
		
		CatalogList list = new CatalogList() ;
		
		list.setCatalogs((List<Catalog>) result.get("catalogs")) ;
		
		return list ;
	}
}
