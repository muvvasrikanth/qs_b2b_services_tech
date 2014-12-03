package com.qs.services.dao;

import java.util.List;
import java.util.Map;

import com.qs.services.domain.Product;
import com.qs.services.domain.ProductImage;

public interface ProductDao {

	public Map <String, ProductImage> getMediumHeroImageUrls(List<Product> products) ;
	
}
