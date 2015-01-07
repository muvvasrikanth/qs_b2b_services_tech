package com.qs.services;

import java.io.IOException;
import java.text.ParseException;

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
import com.qs.services.domain.SAPActiveSeasonProductList;
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
		
		if(logger.isInfoEnabled()){logger.info("Call to [GET] seasons with salesRepId=" + salesRepId);}
		
		SAPPrebookSeasonList seasonList = service.getSeasons(salesRepId) ;
		return ServiceUtil.successResult(seasonList);
	}

	@RequestMapping(value="/products/salesrep/{salesRepId}/brand/{brandId}/season/{seasonId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getProducts(@PathVariable String salesRepId, @PathVariable String brandId, @PathVariable String seasonId, HttpServletRequest request, HttpServletResponse response){
		
		String lastUpdateParm = request.getParameter("lastUpdate") ;
		
		if(logger.isInfoEnabled()){logger.info("Call to getProducts(" + salesRepId + ", " + brandId + ", " + seasonId + ", " + lastUpdateParm + ")");}
		DataResult result = null ;
		
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep(salesRepId);
		srbs.setSince(lastUpdateParm != null ? lastUpdateParm : "");
		BrandSeason bs = new BrandSeason() ;
		bs.setBrand(brandId);
		bs.setSeason(seasonId);
		srbs.getBrandSeasons().add(bs) ;
		SAPActiveSeasonProductList productList = new SAPActiveSeasonProductList() ;
		
		try {
			if(logger.isInfoEnabled()){logger.info("Call to [GET] products with [" + new ObjectMapper().writeValueAsString(srbs) + "]");}
			productList = service.getSeasonProducts(srbs) ;
			result = ServiceUtil.successResult(productList) ;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = ServiceUtil.errorResult(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error while retrieving products for [" + srbs.getSalesRep() + "]") ;
		} catch (ParseException e) {
			logger.error(e.getMessage(), e); ;
			result = ServiceUtil.errorResult(HttpStatus.INTERNAL_SERVER_ERROR, "There was a problem parsing information while retrieving products for [" + srbs.getSalesRep() + "]") ;
		}
		
		if(logger.isInfoEnabled()){
			String msg = "Search criteria [SalesRepId=" + salesRepId + ", BrandId=" + brandId + ", SeasonId=" + seasonId + "] :: " ;
			if(productList != null){
				msg += "ET_SEASONS (" + (productList.getSeasons() != null ? productList.getSeasons().size() : "Undefined") + ") ";
				msg += "ET_SEASON_PRODUCTS (" + (productList.getActiveSeasons() != null ? productList.getActiveSeasons().size() : "Undefined") + ") " ;
				msg += "ET_PRODUCTS (" + (productList.getProducts() != null ? productList.getProducts().size() : "Undefined") + ") " ;
				msg += "ET_PRODUCT_SIZES (" + (productList.getProductSizes() != null ? productList.getProductSizes().size() : "Undefined") + ") " ;
				msg += "ET_PRODUCT_PRICES (" + (productList.getProductPrices() != null ? productList.getProductPrices().size() : "Undefined") + ") " ;
				msg += "ET_LOOKUP_TABLE (" + (productList.getLookups() != null ? productList.getLookups().size() : "Undefined") + ") " ;
				msg += "ET_PRODUCT_SALES_AREAS (" + (productList.getProductSalesAreas() != null ? productList.getProductSalesAreas().size() : "Undefined") + ")" ;
			}
			logger.info(msg);
		}
		
		return result ;
	}
}
