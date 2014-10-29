package com.qs.services.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CustomerDetail {
    
    @JsonProperty("CUSTOMER")
    private String customer;
    
    @JsonProperty("NAME")
    private String name;

    @JsonProperty("ADDRESS1")
    private String addr1;

    @JsonProperty("ADDRESS2")
    private String addr2;

    @JsonProperty("CITY")
    private String city;

    @JsonProperty("STATE")
    private String region;

    @JsonProperty("COUNTRY")
    private String country;

    @JsonProperty("COUNTRY_NAME")
    private String countryName;

    @JsonProperty("ZIP_CODE")
    private String postalCode;

    @JsonProperty("TELEPHONE")
    private String telephone;

    @JsonProperty("BLOCKED")
    private String blocked;
    
    public String getCustomer() {
        return customer;
    }
    public void setCustomerId(String customer) {
        this.customer = customer;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress1() {
        return addr1;
    }
    public void setAddress1(String address) {
        this.addr1 = address;
    }
    public String getAddress2() {
    	return addr2;
    }
    public void setAddress2(String address) {
    	this.addr2 = address;
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
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
    public String getBlocked() {
        return blocked;
    }
    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }


}

