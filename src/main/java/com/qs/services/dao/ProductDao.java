package com.qs.services.dao;

import java.util.List;
import java.util.Map;

import com.qs.services.domain.Product;

public interface ProductDao {

	public Map <String, String> getMediumHeroImageUrls(List<Product> products) ;
	
}
