package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CustomerSalesrep {
    
    @JsonProperty("SALES_REP")
    private String salesRep;

    @JsonProperty("CUSTOMER")
    private String customer;

    public String getSalesRep() {
        return salesRep;
    }
    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }
    
    public String getCustomer() {
        return customer;
    }
    public void setCustomerId(String customer) {
        this.customer = customer;
    }
}
