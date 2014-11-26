package com.qs.services.sao;

import com.qs.services.domain.CustomerList;
import com.qs.services.domain.SAPCustomer;

public interface CustomerSao {

	public CustomerList getCustomers(String salesRepId) ;
	
	public SAPCustomer getCustomerDetails(String customerNumber) ;
	
}
