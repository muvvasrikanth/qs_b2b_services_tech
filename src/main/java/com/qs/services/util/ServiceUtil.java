package com.qs.services.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

public class ServiceUtil {
	
	@Autowired
	private Config config ;

	public HttpHeaders createHeaders() {
		
		return new HttpHeaders() {
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
