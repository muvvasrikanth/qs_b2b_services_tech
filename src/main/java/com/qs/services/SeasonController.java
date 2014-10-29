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

import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.service.SeasonService;

@Controller
public class SeasonController {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonController.class);
	
	@Autowired
	private SeasonService service ;
	
	@RequestMapping(value = "/seasons/salesrep/{salesRepId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public SAPActiveSeasonProductList getSeasons(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		logger.info("Call to [GET] seasons with salesRepId=" + salesRepId);
		
		SAPActiveSeasonProductList seasonList = service.getSeasons(salesRepId) ;
		return seasonList;
	}
	
}
