package com.qs.services.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map <String, ProductImage> getMediumHeroImageUrls(List<Product> products) {
		Map <String, ProductImage> m = null ;
		if(products.size() > 0){
			StringBuilder sql = new StringBuilder("SELECT * FROM bgx_product_images WHERE material_number in ('") ;
			int index = 0 ;
			for(Product p : products){
				sql.append(p.getProduct()) ;
				sql.append((index++ < products.size()-1 ? "', '" : "'")) ;
			}
			sql.append(")  AND angle='FRT1' AND size = 420") ;
	
			if(logger.isDebugEnabled()){logger.debug("Executing: " + sql);}
			
			List<ProductImage> piList = template.query(sql.toString(), new ProductImageRowMapper()) ;
			
			m = new HashMap <String, ProductImage> () ;
			
			for(ProductImage pi : piList){
				m.put(pi.getMaterialNumber(), pi) ;
			}
		}
		return m ;
	}

}
