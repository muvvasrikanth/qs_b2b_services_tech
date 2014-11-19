package com.qs.services.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.dao.ProductDao;
import com.qs.services.dao.SeasonDao;
import com.qs.services.domain.BrandSeason;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeason;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SalesRepBrandSeasons;
import com.qs.services.sao.SeasonSao;
import com.qs.services.service.SeasonService;

@Service("SeasonService")
public class SeasonServiceImpl implements SeasonService {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonServiceImpl.class);

	private static final Object IS_ACTIVE = "AC";

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
		logger.info("There are (" + prebookSeasons.getPrebookSeasons().size() + ") seasons from SAP");
		
		ObjectMapper mapper = new ObjectMapper() ;
		
		List <SAPPrebookSeason> seasons = new ArrayList<SAPPrebookSeason>() ;
		
		for(SAPPrebookSeason sapSeason : prebookSeasons.getPrebookSeasons()){
			logger.info("Checking season status for (SalesOrg=" + sapSeason.getSalesOrg() + ", Season=" + sapSeason.getSeason()+ ")") ;
			sapSeason.setStatuses(dao.getSeasonStatus(sapSeason.getSalesOrg(), sapSeason.getSeason()));
		
			if (! contains(seasons, sapSeason) && sapSeason.isActive()){
				logger.info("Adding (" + mapper.writeValueAsString(sapSeason) + ")");
				seasons.add(sapSeason) ;
			}
			
		}
		
		logger.info("There are (" + seasons.size() + ") seasons being returned");
		
		prebookSeasons.setPrebookSeasons(seasons);
		
		return prebookSeasons ;
	}

	@Override
	public SAPActiveSeasonProductList getSeasonProducts(SalesRepBrandSeasons salesRepBrandSeasons) throws JsonProcessingException {

		SAPActiveSeasonProductList products = sao.getSeasonProducts(salesRepBrandSeasons);
		
		BrandSeason bs = salesRepBrandSeasons.getBrandSeasons().get(0) ;
		
		logger.info("There are (" + products.getProducts().size() + ") products returned from SAP for (" + bs.getBrand() + "|" + bs.getSeason() + ")" ) ;
		
		if(products != null && products.getProducts() != null && products.getProducts().size() > 0){
			Map <String, String> imageUrls = productDao.getMediumHeroImageUrls(products.getProducts()) ;
			logger.info("There are (" + imageUrls.keySet().size() + ") image urls for the provided products");
			logger.debug("Found Image URLs [" + imageUrls + "]");
			String url = null ;
			for(int i=0; i<products.getProducts().size(); i++){
				url = imageUrls.get(products.getProducts().get(i).getProduct()) ;
				products.getProducts().get(i).setImageUrl(url);
			}
		}
		
		return products ;		
	}
	
	private boolean contains(List<SAPPrebookSeason> list, SAPPrebookSeason season){
		for(SAPPrebookSeason s : list){
			logger.info("s (" + s.getBrand() + ", " + s.getSalesOrg() + ", " + s.getSeason() + "): season (" + season.getBrand() + ", " + season.getSalesOrg() + ", " + season.getSeason() + ")") ;
			if(s.compareTo(season) == 1){
				logger.info("FOUND");
				return true ;
			}
		}
		logger.info("NOT FOUND");
		return false ;
	}
}
