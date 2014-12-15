package com.qs.services.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class SAPBasicAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(SAPBasicAuthenticationProvider.class);
    
    @Autowired
	private Config config;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		Authentication resultAuthentication = authentication ;

		String user = authentication.getName(), password = (String) authentication.getCredentials(), auth=null ;
		if(logger.isDebugEnabled()){logger.debug("Authentication (User=" + user + " : Password="+ password + ")");}
		
		HttpClient httpClient = new DefaultHttpClient() ;
		String soapBody = createSoapRequest(user) ;
		
		if(logger.isDebugEnabled()){logger.debug("Authenticate SOAP Envelope: " + soapBody);}
		
		try {
			StringEntity strEntity = new StringEntity(soapBody, "text/xml", "UTF-8") ;
			HttpPost post = new HttpPost(config.getAuthUrl()) ;
			post.setHeader("SOAPAction", "getUser");
			post.setEntity(strEntity);
			
			auth = user + ":" + password ;
			if(logger.isDebugEnabled()){logger.debug("Authorization " + auth);}
			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))) ;
			String authHeader = "Basic " + new String(encodedAuth) ;
			post.setHeader("Authorization", authHeader);
			
			HttpResponse response = httpClient.execute(post) ;
			int responseCode = response.getStatusLine().getStatusCode() ;
			String reason = response.getStatusLine().getReasonPhrase() ;
			if(logger.isDebugEnabled()){logger.debug("SAP Authentication return code: " + responseCode + " : " + reason); }
			
			HttpEntity respEntity = response.getEntity() ;
			if(respEntity != null){
				logger.debug(EntityUtils.toString(respEntity)) ;
				if(responseCode == HttpStatus.OK.value()){
					Collection <SimpleGrantedAuthority> authorities = new ArrayList <SimpleGrantedAuthority> () ;
					authorities.add(new SimpleGrantedAuthority("ROLE_USER")) ;
					resultAuthentication = new UsernamePasswordAuthenticationToken(user, password, authorities) ;
				} else {
					if(logger.isWarnEnabled()){logger.warn("Attempt to authenticate (" + soapBody + ") response code was not (OK), was [" + responseCode + "] - " + reason) ;}
					throw new BadCredentialsException("Authentication Failed") ;
				}
			} else {
				logger.error("Response entity was null");
				throw new BadCredentialsException("Authentication Failed") ;
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} 
		
		return resultAuthentication ;
	}

//	JTryon - Leaving this code commented out for now, replaced with code above	
//		try {
//			HttpClient httpclient = new DefaultHttpClient();
//			String soapBody = this.createSoapRequest(authentication.getName());
//			logger.info(soapBody) ;
//			StringEntity strEntity = new StringEntity(soapBody, "text/xml", "UTF-8");
//			HttpPost post = new HttpPost(config.getAuthUrl());
//			post.setHeader("SOAPAction","getUser");
//			post.setEntity(strEntity);
//			
//			String user = authentication.getName();
//			String password = authentication.getCredentials().toString();
//			String auth = user + ":" + password;
//			logger.info(auth);
//			byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//			String authHeader = "Basic " + new String(encodedAuth);
//			post.setHeader("Authorization", authHeader);
//			
//			HttpResponse response = httpclient.execute(post);
//			logger.info("SAP Auth return code: " + response.getStatusLine().getStatusCode());
//
//			HttpEntity respEntity = response.getEntity();
//			if (respEntity != null) {
//				logger.debug(EntityUtils.toString(respEntity));
//				if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
//					Collection authorities = new ArrayList();
//					authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//					return new UsernamePasswordAuthenticationToken(user, password, authorities);
//				}
//			}
//		} catch (Exception e) {
//			logger.error("Other exception = " + e.toString(), e);
//		} 
//		return authentication;
//	}
	
	private String createSoapRequest(String user) {
		return "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
				+ " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
				+ " xmlns:prt=\"prt:service:com.sapportals.portal.prt.webservice.usermanagement.UMWebService\">"
				+ "<soapenv:Header/>"
				+ "<soapenv:Body>"
				+ "<prt:getUser soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"
				+ "<getUser_1_param2 xsi:type=\"xsd:string\">"
				+ user
				+ "</getUser_1_param2>"
				+ "</prt:getUser>"
				+ "</soapenv:Body>"
				+ "</soapenv:Envelope>";
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
}
