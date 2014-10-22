package com.qs.services.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CustomerSalesArea {
    
    @JsonProperty("CUSTOMER")
    private String customer;

    @JsonProperty("SALES_ORG")
    private String salesOrg;

    @JsonProperty("DISTRIBUTION_CHANNEL")
    private String distributionChannel;

    @JsonProperty("BRAND")
    private String brand;

    @JsonProperty("PRICE_LIST")
    private String priceList;

    @JsonProperty("BLOCKED")
    private String blocked;
    
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
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
    public String getPriceList() {
        return priceList;
    }
    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }
    public String getBlocked() {
        return blocked;
    }
    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

}

