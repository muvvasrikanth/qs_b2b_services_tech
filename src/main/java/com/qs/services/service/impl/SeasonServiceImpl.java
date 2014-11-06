package com.qs.services.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.dao.ProductDao;
import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.Product;
import com.qs.services.domain.ProductPrice;
import com.qs.services.domain.ProductSize;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SalesRepBrandSeasons;
import com.qs.services.domain.Season;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.SeasonService;

@Service("SeasonService")
public class SeasonServiceImpl implements SeasonService {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonServiceImpl.class);

	@Autowired
	private SeasonDao dao ;
	
	@Autowired
	private ProductDao productDao ;

	@Autowired
	private SeasonSao sao ;

	/*
	 * 
	 * How to get the seasons 
	 * 
	 * 1) Use the salesRepId from the sales rep profile to call SeasonSao.getRepPrebkSeasons(...)
	 * 
	 * This will get a list of prebook seasons for the sales rep
	 * 
	 * 2) Use the resulting list from (1) to call SeasonSao.getActiveSeasonProducts(...)
	 * 
	 * This will get a list of products for the seasons for the sales rep
	 * 
	 * 3) Use the resulting list from (1) to call SeasonDao.getSeason(...) with the sales_org, season_id and collection
	 * 
	 * This will get detail information about that season from the connect database
	 * 
	 * 
	 */
	@Override
	public SAPPrebookSeasonList getSeasons(String salesRepId) throws JsonGenerationException, 
								JsonMappingException, IOException {
		SAPPrebookSeasonList prebookSeasons = sao.getRepPrebkSeasons(salesRepId);
		return prebookSeasons ;
//		SAPActiveSeasonProductList activeSeasonProducts = sao.getActiveSeasonProducts(salesRepId, prebookSeasons);
//		
//		if(activeSeasonProducts != null && activeSeasonProducts.getProducts() != null){
//			Map <String, String> imageUrls = productDao.getMediumHeroImageUrls(activeSeasonProducts.getProducts()) ;
//			String url = null ;
//			for(int i=0; i<activeSeasonProducts.getProducts().size(); i++){
//				url = imageUrls.get(activeSeasonProducts.getProducts().get(i).getProduct()) ;
//				logger.info("Adding (" + url + ") to (" + activeSeasonProducts.getProducts().get(i).getProduct() + ")");
//				activeSeasonProducts.getProducts().get(i).setImageUrl(url);
//			}
//		}
//
//		for (SAPPrebookSeason prebookSeason : prebookSeasons.getPrebookSeasons()) {
//			try {
//				Season season = dao.getSeason(prebookSeason.getSalesOrg(), prebookSeason.getSeason(), 
//						prebookSeason.getCollection());
//				activeSeasonProducts.getSeasons().add(season);
//			} catch (IllegalStateException ise) {
//				logger.error("Failed to get season, salesOrg: " + prebookSeason.getSalesOrg()
//						+ ", season: " +  prebookSeason.getSeason() 
//						+ ", collection: " + prebookSeason.getCollection(), ise);
//			}
//		}
//		
//		// Blank out the product lists for testing
//		activeSeasonProducts.setProducts(new ArrayList<Product>()); ;
//		activeSeasonProducts.setProductPrices(new ArrayList<ProductPrice>());
//		activeSeasonProducts.setProductSizes(new ArrayList<ProductSize>());
//		
//		return activeSeasonProducts;
	}

	@Override
	public SAPActiveSeasonProductList getSeasonProducts(SalesRepBrandSeasons salesRepBrandSeasons) throws JsonProcessingException {

		return sao.getSeasonProducts(salesRepBrandSeasons);
		
	}
}
