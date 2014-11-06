package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.domain.DataResult;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SalesRepBrandSeasons;
import com.qs.services.service.SeasonService;
import com.qs.services.util.ServiceUtil;

@Controller
public class SeasonController {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonController.class);
	
	@Autowired
	private SeasonService service ;
	
	@RequestMapping(value = "/seasons/salesrep/{salesRepId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getSeasons(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		logger.info("Call to [GET] seasons with salesRepId=" + salesRepId);
		
		SAPActiveSeasonProductList seasonList = service.getSeasons(salesRepId) ;
		return ServiceUtil.successResult(seasonList);
	}

	@RequestMapping(value="/products/salesrep", method = RequestMethod.GET, produces = "application/jason")
	@ResponseBody
	public DataResult getProducts(@RequestBody SalesRepBrandSeasons salesRepBrandSeasons, HttpServletRequest request, HttpServletResponse response){
		
		DataResult result = null ;
		try {
			logger.info("Call to [GET] products with [" + new ObjectMapper().writeValueAsString(salesRepBrandSeasons) + "]");
			result = ServiceUtil.successResult(service.getSeasonProducts(salesRepBrandSeasons)) ;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = ServiceUtil.errorResult(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error while retrieving products for [" + salesRepBrandSeasons.getSalesRep() + "]") ;
		}
		
		return result ;
	}
}
