package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SeasonList {

	@JsonProperty("ET_SEASONS")
	private List <Season> seasons = new ArrayList <Season> () ;

	@JsonProperty("ET_SEASON_PRODUCTS")
	private SAPActiveSeasonProductList activeSeasonProducts;
	
	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	public void setSeasonProducts(
			SAPActiveSeasonProductList activeSeasonProducts) {
		this.activeSeasonProducts = activeSeasonProducts;
	}
	
	public SAPActiveSeasonProductList getSeasonProducts() {
		return activeSeasonProducts;
	}	
}
