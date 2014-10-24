package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPActiveSeason {

	@JsonProperty("SALES_ORG") 
	private String salesOrg ;
	
	@JsonProperty("SEASON") 
	private String season ;
	
	@JsonProperty("BRAND") 
	private String brand ;
	
	@JsonProperty("PRODUCT") 
	private String product ;
	
	@JsonProperty("START_DATE") 
	private String startDate ;
	
	@JsonProperty("END_DATE") 
	private String endDate ;
	
	@JsonProperty("ATP_STATUS") 
	private String atpStatus ;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAtpStatus() {
		return atpStatus;
	}

	public void setAtpStatus(String atpStatus) {
		this.atpStatus = atpStatus;
	}
	
	
	
}
