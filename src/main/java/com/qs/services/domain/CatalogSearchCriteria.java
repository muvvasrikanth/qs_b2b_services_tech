package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CatalogSearchCriteria {

	@JsonProperty("ID")
	private Integer id ;

	@JsonProperty("CATALOGUEID")
	private Integer catalogueId ;

	@JsonProperty("SEARCHTYPECODE")
	private String searchTypeCode ;

	@JsonProperty("SEARCHTYPE")
	private String searchType ;

	@JsonProperty("SEARCHVALUECODE")
	private String searchValueCode ;

	@JsonProperty("SEARCHVALUE")
	private String searchValue ;

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

	public Integer getCatalogueId() {
		return catalogueId;
	}

	public void setCatalogueId(Integer catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getSearchTypeCode() {
		return searchTypeCode;
	}

	public void setSearchTypeCode(String searchTypeCode) {
		this.searchTypeCode = searchTypeCode;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValueCode() {
		return searchValueCode;
	}

	public void setSearchValueCode(String searchValueCode) {
		this.searchValueCode = searchValueCode;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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
