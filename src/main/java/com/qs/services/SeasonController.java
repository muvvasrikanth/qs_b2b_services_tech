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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.BrandSeason;
import com.qs.services.domain.DataResult;
import com.qs.services.domain.SAPPrebookSeasonList;
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
		
		SAPPrebookSeasonList seasonList = service.getSeasons(salesRepId) ;
		return ServiceUtil.successResult(seasonList);
	}

	@RequestMapping(value="/products/salesrep/{salesRepId}/brand/{brandId}/season/{seasonId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getProducts(@PathVariable String salesRepId, @PathVariable String brandId, @PathVariable String seasonId, HttpServletRequest request, HttpServletResponse response){
		
		String lastUpdateParm = request.getParameter("lastUpdate") ;
		
		logger.info("Call to getProducts(" + salesRepId + ", " + brandId + ", " + seasonId + ", " + lastUpdateParm + ")");
		DataResult result = null ;
		
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep(salesRepId);
		srbs.setSince(lastUpdateParm);
		BrandSeason bs = new BrandSeason() ;
		bs.setBrand(brandId);
		bs.setSeason(seasonId);
		srbs.getBrandSeasons().add(bs) ;
		
		try {
			logger.info("Call to [GET] products with [" + new ObjectMapper().writeValueAsString(srbs) + "]");
			result = ServiceUtil.successResult(service.getSeasonProducts(srbs)) ;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = ServiceUtil.errorResult(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error while retrieving products for [" + srbs.getSalesRep() + "]") ;
		}
		
		return result ;
	}
}
