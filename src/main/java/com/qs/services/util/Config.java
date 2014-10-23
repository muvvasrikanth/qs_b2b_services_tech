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
}
