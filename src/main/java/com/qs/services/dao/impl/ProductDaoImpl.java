package com.qs.services.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.qs.services.dao.ProductDao;
import com.qs.services.dao.mapper.ProductImageRowMapper;
import com.qs.services.domain.Product;
import com.qs.services.domain.ProductImage;
import com.qs.services.util.Config;

@Component
public class ProductDaoImpl implements ProductDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class) ;
	
	@Autowired
	private JdbcTemplate template ;
	
	@Autowired
	private Config config ;

	@Override
	public String getMediumHeroImageUrl(Product p) {

		String sql = "SELECT * FROM bgx_product_images WHERE material_number='" + p.getProduct() + "' AND angle='FRT1' AND size between 400 and 600" ; 
		
		logger.info("Executing: " + sql);
		
		List<ProductImage> piList = template.query(sql, new ProductImageRowMapper()) ;
		
		if(piList == null || piList.size() == 0){
			logger.warn("Incorrect number of records (" + piList.size() + ") returned for " + p.getProduct() + " should be (1)") ;
			return null ;
		} else {		
			return config.getS3Url() + piList.get(0).getS3Path() ;
		}
	}

}
