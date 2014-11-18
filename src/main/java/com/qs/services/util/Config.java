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

    @Value("${sap_auth_url:127.0.0.1}")
    private String authUrl;

    @Value("${sap_auth_user:}")
    private String authUser;
    
    @Value("${s3.bucket.name}")
    private String s3BucketName ;
    
    @Value("s3.access.key")
    private String s3AccessKey ;
    
    @Value("s3.secret.key")
    private String s3SecretKey ;
    
    public String getAuthUser() {
		return authUser;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

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

	public String getS3BucketName() {
		return s3BucketName;
	}

	public void setS3BucketName(String s3BucketName) {
		this.s3BucketName = s3BucketName;
	}

	public String getS3AccessKey() {
		return s3AccessKey;
	}

	public void setS3AccessKey(String s3AccessKey) {
		this.s3AccessKey = s3AccessKey;
	}

	public String getS3SecretKey() {
		return s3SecretKey;
	}

	public void setS3SecretKey(String s3SecretKey) {
		this.s3SecretKey = s3SecretKey;
	}
	
	
}
