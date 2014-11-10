package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Catalog {
	
	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("NAME")
	private String name ;
	
	@JsonProperty("BRAND")
	private String brand ;

	@JsonProperty("SALES_ORG")
	private String salesOrg ;

	@JsonProperty("DIST_CH")
	private String distributionChannel ;

	@JsonProperty("LANGUAGE_CODE")
	private String languageCode ;
	
	@JsonProperty("VALIDFROM")
	private Date validFrom ;
	
	@JsonProperty("VALIDTO")
	private Date validTo ;
	
	@JsonProperty("TYPE")
	private String type ;
	
	@JsonProperty("NOOFSEARCHCRITERIA")
	private Integer numberOfSearchCriteria ;
	
	@JsonProperty("STATUS")
	private String status ;
	
	@JsonProperty("CREATEDBY")
	private String createdBy ;
	
	@JsonProperty("CREATEDDATETIME")
	private Date createdDateTime ;
	
	@JsonProperty("MODIFIEDBY")
	private String modifiedBy ;
	
	@JsonProperty("MODIFIEDDATETIME")
	private Date modifiedDateTime ;
	
	@JsonProperty("PARENTCATALOGUEID")
	private Integer parentCatalogId ;
	
	@JsonProperty("LEVEL")
	private Integer level ;
	
	@JsonProperty("IMAGE_URL")
	private String imageUrl ;

	@JsonProperty("CATALOG_SEARCH_CRITERIA_LIST")
	private CatalogSearchCriteriaList catalogSearchCriteriaList;

	public void setCatalogSearchCriteriaList(CatalogSearchCriteriaList csc) {
		this.catalogSearchCriteriaList = csc;
	}
	
	public CatalogSearchCriteriaList GetCatalogSearchCriteriaList() {
		return this.catalogSearchCriteriaList;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumberOfSearchCriteria() {
		return numberOfSearchCriteria;
	}

	public void setNumberOfSearchCriteria(Integer numberOfSearchCriteria) {
		this.numberOfSearchCriteria = numberOfSearchCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getParentCatalogId() {
		return parentCatalogId;
	}

	public void setParentCatalogId(Integer parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public CatalogSearchCriteriaList getCatalogSearchCriteriaList() {
		return catalogSearchCriteriaList;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
