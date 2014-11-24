package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProductSize {

	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("SALESDOC_PRODUCT_ID")
	private Integer salesDocProductId ;
	
	@JsonProperty("PRODUCT_NUMBER")
	private String productNumber ;
	
	@JsonProperty("SIZE")
	private String size ;
	
	@JsonProperty("QUANTITY")
	private Integer quantity = 0 ;
	
	@JsonProperty("DIMENSION")
	private String dimension ;
	
	@JsonProperty("CREATEDBY")
	private String createdBy ;
	
	@JsonProperty("CREATEDDATETIME")
	private String createdDateTime ;
	
	@JsonProperty("MODIFIEDBY")
	private String modifiedBy ;
	
	@JsonProperty("MODIFIEDDATETIME")
	private String modifiedDateTime ;

	@JsonProperty("ET_CART_PRODUCT_SIZE_RDD")
	private List<CartProductSizeRdd> cartProductSizeRdds = new ArrayList<CartProductSizeRdd>() ;

	public List<CartProductSizeRdd> getCartProductSizeRdds() {
		return cartProductSizeRdds;
	}

	public void setCartProductSizeRdds(List<CartProductSizeRdd> cartProductSizeRdds) {
		this.cartProductSizeRdds = cartProductSizeRdds;
	}

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

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(String modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	
}
