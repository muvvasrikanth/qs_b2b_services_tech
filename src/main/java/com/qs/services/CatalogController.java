package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.Catalog;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.DataResult;
import com.qs.services.service.CatalogService;
import com.qs.services.util.ServiceUtil;

@Controller
public class CatalogController {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	
	@Autowired
	private CatalogService service ;
	
	@RequestMapping(value = "/catalogs/salesrep/{salesRepId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getCatalogs(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String auth = request.getHeader("x-auth") ;
		if(auth == null){
			logger.warn("Authentication header missing");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null ;
		} else { 
			String[] authTokens = auth.split(":") ;
			if(authTokens == null || authTokens.length != 2 || ! "mobile_user".equals(authTokens[0]) || ! "Quiksilver1".equals(authTokens[1])){
				logger.warn("Authentication header (" + auth + ") was bad authentication failed") ;
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return null ;
			}
		}
		
		logger.info("Call to [GET] catalogs with salesRepId=" + salesRepId);
		CatalogList catalogList = new CatalogList() ;
		
		try{
			catalogList = service.getCatalogs(salesRepId);
			for (Catalog cat : catalogList.getCatalogs()) {
				CatalogSearchCriteriaList csc = service.getCatalogSearchCriteria(cat.getId());
				cat.setCatalogSearchCriteriaList(csc);
			}
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		return ServiceUtil.successResult(catalogList);
	}
	
}
