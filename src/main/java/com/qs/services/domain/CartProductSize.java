package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProductSize {

	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("SALESDOC_PRODUCT_ID")
	private Integer salesDocProductId ;
	
	@JsonProperty("SIZE")
	private String size ;
	
	@JsonProperty("QUANTITY")
	private Integer quantity ;
	
	@JsonProperty("DIMENSION")
	private String dimension ;
	
	@JsonProperty("CREATEDBY")
	private String createdBy ;
	
	@JsonProperty("CREATEDDATETIME")
	private Date createdDateTime ;
	
	@JsonProperty("MODIFIEDBY")
	private String modifiedBy ;
	
	@JsonProperty("MODIFIEDDATETIME")
	private Date modifiedDateTime ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalesDocProductId() {
		return salesDocProductId;
	}

	public void setSalesDocProductId(Integer salesDocProductId) {
		this.salesDocProductId = salesDocProductId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
	
}
