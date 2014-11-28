package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPSalesArea {

	@JsonProperty("SALES_ORG")
	private String salesOrg ;

	@JsonProperty("DISTRIBUTION_CHANNEL")
	private String distributionChannel ;

	@JsonProperty("BRAND")
	private String brand ;

	@JsonProperty("INVALID_FLAG")
	private String invalidFlag ;

	@JsonProperty("CUST_GROUP9")
	private String custGroup9 ;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(String invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public String getCustGroup9() {
		return custGroup9;
	}

	public void setCustGroup9(String custGroup9) {
		this.custGroup9 = custGroup9;
	}

}
