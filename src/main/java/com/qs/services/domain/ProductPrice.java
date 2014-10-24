package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ProductPrice {

	@JsonProperty("SALES_ORG") 
	private String salesOrg ;
	
	@JsonProperty("DISTRIBUTION_CHANNEL") 
	private String distributionChannel ;
	
	@JsonProperty("PRICE_LIST") 
	private String priceList ;
	
	@JsonProperty("SEASON") 
	private String season ;
	
	@JsonProperty("PRODUCT") 
	private String product ;
	
	@JsonProperty("PRICE_TYPE") 
	private String priceType ;
	
	@JsonProperty("PRICE") 
	private Double price ;
	
	@JsonProperty("CURRENCY") 
	private String currency ;
	
	@JsonProperty("VALID_FROM") 
	private Date validFrom ;
	
	@JsonProperty("VALID_TO") 
	private Date validTo ;

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public String getPriceList() {
		return priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	
}
