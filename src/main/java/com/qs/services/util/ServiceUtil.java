package com.qs.services.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qs.services.domain.DataResult;

@Component
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
    
    public static DataResult errorResult(HttpStatus status, String moreInfo) {
    	DataResult dr = new DataResult(status.value(), status.getReasonPhrase(),
    			moreInfo, "");
        return dr;
    }
    
    public static DataResult successResult(Object data) {
    	DataResult dr = new DataResult(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),
    			"", data);
    	return dr;
    }
}
