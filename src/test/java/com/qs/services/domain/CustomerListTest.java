package com.qs.services.domain;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CustomerListTest {
    
    @Test
    public void testCustomerList() throws Exception{
        
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/data/sapGetCustomers.txt");
        String json = IOUtils.toString(resourceAsStream);
        
        ObjectReader or = new ObjectMapper().reader(CustomerList.class);
        CustomerList customerList = or.readValue(json);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(customerList);
        
        assertEquals(5, customerList.getCustomerDetails().size());
        CustomerDetail detail = customerList.getCustomerDetails().get(0);
        assertEquals("1000001", detail.getCustomer());
        assertEquals("HENDERSON SALES ASSOC. INC", detail.getName());
        assertEquals("4100 Belmont Drive", detail.getAddress1());
        assertEquals("Hood River", detail.getCity());
        assertEquals("OR", detail.getRegion());
        assertEquals("US", detail.getCountry());
        assertEquals("USA", detail.getCountryName());
        assertEquals("97031", detail.getPostalCode());
        assertEquals("", detail.getTelephone());
        assertEquals("", detail.getBlocked());

        assertEquals(5, customerList.getCustomers().size());
        CustomerSalesrep customer = customerList.getCustomers().get(0);
        assertEquals("1000001", customer.getCustomer());
        assertEquals("1002117", customer.getSalesRep());

        assertEquals(5, customerList.getCustomerSalesAreas().size());
        CustomerSalesArea salesArea = customerList.getCustomerSalesAreas().get(0);
        assertEquals("1000001", salesArea.getCustomer());
        assertEquals("10", salesArea.getDistributionChannel());
        assertEquals("", salesArea.getPriceList());
        assertEquals("1000", salesArea.getSalesOrg());
        assertEquals("01", salesArea.getBrand());
        assertEquals("", salesArea.getBlocked());

        
        assertEquals(5, customerList.getCustomerShiptos().size());
        CustomerShipTo shipTo = customerList.getCustomerShiptos().get(0);
        assertEquals("1000001", shipTo.getCustomer());
        assertEquals("1000001", shipTo.getShipTo());
        assertEquals("10", shipTo.getDistributionChannel());
        assertEquals("1000", shipTo.getSalesOrg());
        assertEquals("01", shipTo.getBrand());
        
//        assertEquals(json, result);
    }

}
