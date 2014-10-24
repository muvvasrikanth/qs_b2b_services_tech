package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class SAPPrebookSeason {

	@JsonProperty("SALES_ORG")
	private String salesOrg ;
	
	@JsonProperty("SEASON")
	private String season ;
	
	@JsonProperty("COLLECTION")
	private String collection ;
	
	@JsonProperty("SEASON_TEXT")
	private String seasonText ;

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getSeasonText() {
		return seasonText;
	}

	public void setSeasonText(String seasonText) {
		this.seasonText = seasonText;
	}
	
	
}
