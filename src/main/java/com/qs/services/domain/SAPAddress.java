package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPAddress {

	@JsonProperty("NAME")
	private String name ;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


}
