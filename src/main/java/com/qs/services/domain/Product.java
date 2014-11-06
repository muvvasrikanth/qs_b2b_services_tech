package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Product {

	@JsonProperty("PRODUCT") 
	private String product ;
	
	@JsonProperty("GENDER") 
	private String gender ;
	
	@JsonProperty("DEMOGRAPHIC") 
	private String demographic ;
	
	@JsonProperty("ACTIVITY") 
	private String activity ;
	
	@JsonProperty("DEPARTMENT") 
	private String department ;
	
	@JsonProperty("CATEGORY") 
	private String category ;
	
	@JsonProperty("PRODUCT_TYPE") 
	private String productType ;
	
	@JsonProperty("PRODUCT_HIERARCHY") 
	private String productHierarchy ;
	
	@JsonProperty("MATERIAL_GROUP") 
	private String materialGroup ;
	
	@JsonProperty("STYLE") 
	private String style ;
	
	@JsonProperty("COLOR") 
	private String color ;
	
	@JsonProperty("MARKETING_COLOR") 
	private String marketingColor ;
	
	@JsonProperty("MARKETING_TEXT") 
	private String marketingText ;
	
	@JsonProperty("UNIT_OF_MEASURE") 
	private String unitOfMeasure ;
	
	@JsonProperty("DESCRIPTION") 
	private String description ;
	
	@JsonProperty("IMAGE_URL") 
	private String imageUrl ;
	
	@JsonProperty("IMAGE_UPDATED_ON")
	private Date imageUpdatedOn ;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDemographic() {
		return demographic;
	}

	public void setDemographic(String demographic) {
		this.demographic = demographic;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductHierarchy() {
		return productHierarchy;
	}

	public void setProductHierarchy(String productHierarchy) {
		this.productHierarchy = productHierarchy;
	}

	public String getMaterialGroup() {
		return materialGroup;
	}

	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarketingColor() {
		return marketingColor;
	}

	public void setMarketingColor(String marketingColor) {
		this.marketingColor = marketingColor;
	}

	public String getMarketingText() {
		return marketingText;
	}

	public void setMarketingText(String marketingText) {
		this.marketingText = marketingText;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getImageUpdatedOn() {
		return imageUpdatedOn;
	}

	public void setImageUpdatedOn(Date imageUpdatedOn) {
		this.imageUpdatedOn = imageUpdatedOn;
	}
	
	
}
