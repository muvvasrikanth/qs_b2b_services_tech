package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("rawtypes")
@JsonAutoDetect
public class SAPActiveSeasonProductList {

	@JsonProperty("ET_SEASONS")
	private List <Season> seasons = new ArrayList <Season> () ;
	
	@JsonProperty("ET_SEASON_PRODUCTS")
	private List<SAPActiveSeason> activeSeasons = new ArrayList<SAPActiveSeason>() ;
	
	@JsonProperty("ET_PRODUCTS")
	private List<Product> products = new ArrayList<Product>() ;
	
	@JsonProperty("ET_PRODUCT_SIZES")
	private List<ProductSize> productSizes = new ArrayList<ProductSize>() ;
	
	@JsonProperty("ET_PRODUCT_PRICES")
	private List<ProductPrice> productPrices = new ArrayList<ProductPrice>() ;
	
	@JsonProperty("ET_LOOKUP_TABLE")
	private List<Lookup> lookups = new ArrayList<Lookup>() ;

    @JsonProperty("ET_PRODUCT_SALES_AREAS")
    private List<ProductSalesArea> productSalesAreas = new ArrayList<>();
    
    @JsonProperty("ET_PRODUCT_SEARCH_DROPDOWNS")
    private List<ProductSearchDropdown> searchDropdowns = new ArrayList<>();
    
	@JsonProperty("ET_RETURN")
    private List<SAPReturn> etReturn = new ArrayList<SAPReturn>();
    
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
	
	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	public List<ProductSalesArea> getProductSalesAreas() {
		return productSalesAreas;
	}

	public void setProductSalesAreas(List<ProductSalesArea> productSalesAreas) {
		this.productSalesAreas = productSalesAreas;
	}

	public List<ProductSearchDropdown> getSearchDropdowns() {
		return searchDropdowns;
	}

	public void setSearchDropdowns(List<ProductSearchDropdown> searchDropdowns) {
		this.searchDropdowns = searchDropdowns;
	}

	public List<SAPReturn> getEtReturn() {
		return etReturn;
	}

	public void setEtReturn(List<SAPReturn> etReturn) {
		this.etReturn = etReturn;
	}

	
}
