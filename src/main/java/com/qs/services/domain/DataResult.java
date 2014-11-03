package com.qs.services.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class DataResult {
	
	@JsonProperty("status")
	private String status = "";
	
	@JsonProperty("message")
	private String message ="";
	
	@JsonProperty("more_info")
	private String moreInfo = "";
	
	@JsonProperty("data")
	private Object data = null;
	
	public DataResult(int status, String message, String moreInfo, Object data) {
		this.status = String.valueOf(status);
		this.message = message;
		this.moreInfo = moreInfo;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
