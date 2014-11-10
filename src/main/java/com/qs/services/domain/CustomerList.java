package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("rawtypes")
@JsonAutoDetect
public class CustomerList {

	private static final long serialVersionUID = 8679177667910371085L;
	
	@JsonProperty("ET_CUSTOMERS")
	private List<CustomerSalesrep> customers = new ArrayList<CustomerSalesrep>();
    
    @JsonProperty("ET_CUSTOMER_DETAILS")
	private List<CustomerDetail> customerDetails = new ArrayList<CustomerDetail>();
    
    @JsonProperty("ET_CUSTOMER_SALESAREAS")
    private List<CustomerSalesArea> customerSalesAreas = new ArrayList<CustomerSalesArea>();
    
    @JsonProperty("ET_CUSTOMER_SHIPTOS")
    private List<CustomerShipTo> customerShiptos = new ArrayList<CustomerShipTo>();
    
	@JsonProperty("ET_RETURN")
    private List etReturn = new ArrayList<>();
    
	public List<CustomerSalesrep> getCustomers() {
        return customers;
    }
    public void setCustomers(List<CustomerSalesrep> customers) {
        this.customers = customers;
    }
    public List<CustomerDetail> getCustomerDetails() {
        return customerDetails;
    }
    public void setCustomerDetails(List<CustomerDetail> customerDetails) {
        this.customerDetails = customerDetails;
    }
    public List<CustomerSalesArea> getCustomerSalesAreas() {
        return customerSalesAreas;
    }
    public void setCustomerSalesAreas(List<CustomerSalesArea> customerSalesAreas) {
        this.customerSalesAreas = customerSalesAreas;
    }
    public List<CustomerShipTo> getCustomerShiptos() {
        return customerShiptos;
    }
    public void setCustomerShiptos(List<CustomerShipTo> customerShiptos) {
        this.customerShiptos = customerShiptos;
    }

}
