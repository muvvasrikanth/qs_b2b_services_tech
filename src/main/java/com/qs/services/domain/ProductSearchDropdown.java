package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ProductSearchDropdown {

	@JsonProperty("SALES_ORG") 
	private String salesOrg ;
	
	@JsonProperty("BRAND") 
	private String brand ;
	
	@JsonProperty("SEASON") 
	private String season ;
	
	@JsonProperty("DEMOGRAPHIC") 
	private String demographic ;
	
	@JsonProperty("DEPARTMENT") 
	private String department ;
	
	@JsonProperty("CATEGORY") 
	private String category ;
	
	@JsonProperty("DEMOGRAPHIC_TEXT") 
	private String demographicText ;
	
	@JsonProperty("DEPARTMENT_TEXT") 
	private String departmentText ;
	
	@JsonProperty("CATEGORY_TEXT") 
	private String categoryText ;

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getDemographic() {
		return demographic;
	}

	public void setDemographic(String demographic) {
		this.demographic = demographic;
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

	public String getDemographicText() {
		return demographicText;
	}

	public void setDemographicText(String demographicText) {
		this.demographicText = demographicText;
	}

	public String getDepartmentText() {
		return departmentText;
	}

	public void setDepartmentText(String departmentText) {
		this.departmentText = departmentText;
	}

	public String getCategoryText() {
		return categoryText;
	}

	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}


}
