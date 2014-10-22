package com.qs.services.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CustomerShipTo {
    @JsonProperty("CUSTOMER")
    private String customer;

    @JsonProperty("SHIPTO")
    private String shipTo;

    @JsonProperty("SALES_ORG")
    private String salesOrg;

    @JsonProperty("DISTRIBUTION_CHANNEL")
    private String distributionChannel;

    @JsonProperty("BRAND")
    private String brand;
    
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
    public String getShipTo() {
        return shipTo;
    }
    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }
}

