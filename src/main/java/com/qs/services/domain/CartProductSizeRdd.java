package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProductSizeRdd {

	@JsonProperty("ID") 
	private Integer id ;
	
	@JsonProperty("PRODUCT_SIZE_ID") 
	private Integer productSizeId ;
	
	@JsonProperty("QUANTITY") 
	private Integer quantity ;
	
	@JsonProperty("RDD") 
	private Date requestedDeliveryDate ;
	
	@JsonProperty("ORIGINAL_RDD") 
	private Date originalRequestedDeliveryDate ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductSizeId() {
		return productSizeId;
	}

	public void setProductSizeId(Integer productSizeId) {
		this.productSizeId = productSizeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(Date requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public Date getOriginalRequestedDeliveryDate() {
		return originalRequestedDeliveryDate;
	}

	public void setOriginalRequestedDeliveryDate(Date originalRequestedDeliveryDate) {
		this.originalRequestedDeliveryDate = originalRequestedDeliveryDate;
	}
	
	
}
