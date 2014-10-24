package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPActiveSeasonProductList {

	@JsonProperty("ET_PREEBOOK_SEASON_PRODUCTS")
	private List<SAPActiveSeason> activeSeasons = new ArrayList<SAPActiveSeason>() ;
	
	@JsonProperty("ET_PRODUCTS")
	private List<Product> products = new ArrayList<Product>() ;
	
	@JsonProperty("ET_PRODUCT_SIZES")
	private List<ProductSize> productSizes = new ArrayList<ProductSize>() ;
	
	@JsonProperty("ET_PRODUCT_PRICES")
	private List<ProductPrice> productPrices = new ArrayList<ProductPrice>() ;
	
	@JsonProperty("ET_LOOKUP_TABLE")
	private List<Lookup> lookups = new ArrayList<Lookup>() ;

	public List<SAPActiveSeason> getActiveSeasons() {
		return activeSeasons;
	}

	public void setActiveSeasons(List<SAPActiveSeason> activeSeasons) {
		this.activeSeasons = activeSeasons;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ProductSize> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(List<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public List<Lookup> getLookups() {
		return lookups;
	}

	public void setLookups(List<Lookup> lookups) {
		this.lookups = lookups;
	}
	
	
}
