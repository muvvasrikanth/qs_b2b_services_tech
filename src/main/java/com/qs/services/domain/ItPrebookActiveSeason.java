package com.qs.services.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class ItPrebookActiveSeason {
	@JsonProperty("SALES_ORG")
	private String salesOrg ;
	
	@JsonProperty("SEASON")
	private String season ;
	
	@JsonProperty("COLLECTION")
	private String collection ;
	
	public ItPrebookActiveSeason(String salesOrg, String season,
			String collection) {
		this.salesOrg = salesOrg;
		this.season = season;
		this.collection = collection;
	}

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
}