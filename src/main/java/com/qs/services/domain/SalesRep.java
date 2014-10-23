package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SalesRep {
	
	@JsonProperty("id") 
	private Integer id ;

	@JsonProperty("first_name") 
	private String firstName ;

	@JsonProperty("last_name") 
	private String lastName ;

	@JsonProperty("country") 
	private String country ;

	@JsonProperty("currency_code") 
	private String currencyCode ;

	@JsonProperty("currency_format") 
	private String currencyFormat ;

	@JsonProperty("language_code") 
	private String languageCode ;

	@JsonProperty("date_format") 
	private String dateFormat ;

	@JsonProperty("email") 
	private String email ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyFormat() {
		return currencyFormat;
	}

	public void setCurrencyFormat(String currencyFormat) {
		this.currencyFormat = currencyFormat;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
