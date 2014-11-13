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

	@Override
	public SAPPrebookSeasonList getSeasons(String salesRepId) throws JsonGenerationException, 
								JsonMappingException, IOException {
		SAPPrebookSeasonList prebookSeasons = sao.getRepPrebkSeasons(salesRepId);
		return prebookSeasons ;
	}

	@Override
	public SAPActiveSeasonProductList getSeasonProducts(SalesRepBrandSeasons salesRepBrandSeasons) throws JsonProcessingException {

		SAPActiveSeasonProductList products = sao.getSeasonProducts(salesRepBrandSeasons);
		
		if(products != null && products.getProducts() != null && products.getProducts().size() > 0){
			Map <String, String> imageUrls = productDao.getMediumHeroImageUrls(products.getProducts()) ;
			logger.info("Fourn Image URLs [" + imageUrls + "]");
			String url = null ;
			for(int i=0; i<products.getProducts().size(); i++){
				url = imageUrls.get(products.getProducts().get(i).getProduct()) ;
				products.getProducts().get(i).setImageUrl(url);
			}
		}
		
		return products ;		
	}
}
