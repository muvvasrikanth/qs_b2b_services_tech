package com.qs.services.domain;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CustomerListTest {
    
    @Test
    public void testCustomerList() throws Exception{
        
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/sapGetCustomers.resp");
        String json = IOUtils.toString(resourceAsStream);
        
        ObjectReader or = new ObjectMapper().reader(CustomerList.class);
        CustomerList customerList = or.readValue(json);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = ow.writeValueAsString(customerList);
        
        assertEquals(5, customerList.getCustomerDetails().size());
        assertEquals(5, customerList.getCustomers().size());
        assertEquals(5, customerList.getCustomerSalesAreas().size());
        assertEquals(5, customerList.getCustomerShiptos().size());
        
        assertEquals(json, result);
    }

}
