package com.qs.services.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${sap_user:}")
    private String sapUser;
    
    @Value("${sap_password:}")
    private String sapPassword;
    
    @Value("${sap_service_url:127.0.0.1}")
    private String sapServiceUrl;
    
    @Value("${sap_client}")
    private String sapClient ;
    
    @Value("${base.s3.url}")
    private String s3Url ;

    public String getSapClient() {
		return sapClient;
	}

	public void setSapClient(String sapClient) {
		this.sapClient = sapClient;
	}

	public String getSapUser() {
		return sapUser;
	}

	public void setSapUser(String sapUser) {
		this.sapUser = sapUser;
	}

	public String getSapPassword() {
		return sapPassword;
	}

	public void setSapPassword(String sapPassword) {
		this.sapPassword = sapPassword;
	}

	public String getSapServiceUrl() {
		return sapServiceUrl;
	}

	public void setSapServiceUrl(String sapServiceUrl) {
		this.sapServiceUrl = sapServiceUrl;
	}

	public String getS3Url() {
		return s3Url;
	}

	public void setS3Url(String s3Url) {
		this.s3Url = s3Url;
	}
	
	
}
