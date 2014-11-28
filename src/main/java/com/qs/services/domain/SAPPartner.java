package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPPartner {

	@JsonProperty("SALES_ORG")
	private String salesOrg ;

	@JsonProperty("DISTRIBUTION_CHANNEL")
	private String distributionChannel ;

	@JsonProperty("BRAND")
	private String brand ;

	@JsonProperty("PARTNER_NUMBER")
	private String partnerNumber ;

	@JsonProperty("PARTNER_NAME")
	private String partnerName ;

	@JsonProperty("STREET")
	private String street ;

	@JsonProperty("CITY")
	private String city ;

	@JsonProperty("REGION")
	private String region ;

	@JsonProperty("COUNTRY")
	private String country ;

	@JsonProperty("POSTAL_CODE")
	private String postalCode ;

	@JsonProperty("TELEPHONE")
	private String telephone ;

	@JsonProperty("EMAIL")
	private String email ;

	@JsonProperty("TIME_ZONE")
	private String timeZone ;

	@JsonProperty("LANGUAGE")
	private String language ;

	@JsonProperty("IS_DISTRIBUTOR")
	private String isDistributor ;

	@JsonProperty("EU_PARTNER")
	private String euPartner ;

	@JsonProperty("INVALID_FLAG")
	private String invalidFlag ;

	@JsonProperty("APAC_PARTNER")
	private String apacPartner ;

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

	public String getPartnerNumber() {
		return partnerNumber;
	}

	public void setPartnerNumber(String partnerNumber) {
		this.partnerNumber = partnerNumber;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIsDistributor() {
		return isDistributor;
	}

	public void setIsDistributor(String isDistributor) {
		this.isDistributor = isDistributor;
	}

	public String getEuPartner() {
		return euPartner;
	}

	public void setEuPartner(String euPartner) {
		this.euPartner = euPartner;
	}

	public String getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(String invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public String getApacPartner() {
		return apacPartner;
	}

	public void setApacPartner(String apacPartner) {
		this.apacPartner = apacPartner;
	}

	
}
