package com.qs.services.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class SAPPrebookSeason implements Comparable <SAPPrebookSeason> {

	private static final Object ACTIVE = "AC";

	@JsonProperty("SALES_ORG")
	private String salesOrg ;
	
	@JsonProperty("BRAND")
	private String brand ;
	
	@JsonProperty("SEASON")
	private String season ;
	
	@JsonProperty("COLLECTION")
	private String collection ;
	
	@JsonProperty("START_DATE")
	private Date startDate ;
	
	@JsonProperty("END_DATE")
	private Date endDate ;
	
	@JsonProperty("SEASON_TEXT")
	private String seasonText ;
	
	@JsonProperty("STATUS")
	private List<String> statuses = new ArrayList<String>() ;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	@Override
	public int compareTo(SAPPrebookSeason s) {
		return (this.getBrand().equals(s.getBrand()) 
				&& this.getSalesOrg().equals(s.getSalesOrg()) 
				&& this.getSeason().equals(s.getSeason()) ? 1 : 0) ;
	}

	public boolean isActive() {
		return statuses.contains(ACTIVE) ;
	}
}
