package com.qs.services.sao.impl;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qs.services.domain.CustomerList;
import com.qs.services.domain.SAPCustomer;
import com.qs.services.sao.CustomerSao;
import com.qs.services.util.Config;

@Component("CustomerSao")
public class CustomerSaoImpl implements CustomerSao {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerSaoImpl.class) ;
	
	@Autowired
	private RestTemplate restTemplate ;

	@Autowired
	private Config config ;
	
	@Override
	public CustomerList getCustomers(String salesRepId) {
		String url =config.getSapServiceUrl() + "/CONNECT_MOBILE/RepCustomers?sap-client=" + config.getSapClient();
		String body="{\"I_SALES_REP\":\"" + salesRepId + "\"}";
	    HttpEntity<String> httpEntity = new HttpEntity<String>(body, createHeaders());
		ResponseEntity<CustomerList> result = restTemplate.exchange(url, HttpMethod.POST, 
	    		httpEntity, CustomerList.class);
	    return result.getBody();
	}
	
	@Override
	public SAPCustomer getCustomerDetails(String customerNumber) {
		String url = config.getSapServiceUrl() + "/BGX_AFS_1/CustomerDetails?sap-client=" + config.getSapClient() ;
		String body = "{\"I_CUSTOMER_NUMBER\":\"" + customerNumber + "\"}" ;
		HttpEntity <String> httpEntity = new HttpEntity <String> (body, createHeaders()) ;
		if(logger.isDebugEnabled()){logger.debug("Calling Customer Detail service with " + body);}
		ResponseEntity<SAPCustomer> result = restTemplate.exchange(url, HttpMethod.POST, httpEntity, SAPCustomer.class) ;
		return result.getBody() ;
	}
	
	private HttpHeaders createHeaders() {
		return new HttpHeaders() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				String auth = config.getSapUser() + ":"
						+ config.getSapPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset
						.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

}
