package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Season {

	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("SALES_ORG")
	private String salesOrg ;
	
	@JsonProperty("SEASON_ID")
	private String seasonId ;
	
	@JsonProperty("COLLECTION")
	private String collection ;
	
	@JsonProperty("THEME")
	private String theme ;
	
	@JsonProperty("DELIVERY_DATE_FROM")
	private Date deliveryDateFrom ;
	
	@JsonProperty("DELIVERY_DATE_TO")
	private Date deliveryDateTo ;
	
	@JsonProperty("ORDER_DATE_FROM")
	private Date orderDateFrom ;
	
	@JsonProperty("ORDER_DATE_TO")
	private Date orderDateTo ;
	
	@JsonProperty("APPROVAL_NOTES")
	private String approvalNotes ;
	
	@JsonProperty("APPROVAL_STATUS")
	private String approvalStatus ;
	
	@JsonProperty("STATUS")
	private String status ;
	
	@JsonProperty("CREATED_BY")
	private String createdBy ;
	
	@JsonProperty("CREATED_DATETIME")
	private Date createdDateTime ;
	
	@JsonProperty("MODIFIED_BY")
	private String modifiedBy ;
	
	@JsonProperty("MODIFIED_DATETIME")
	private Date modifiedDateTime ;
	
	@JsonProperty("IS_DEFAULT")
	private String isDefault ;
	
	@JsonProperty("DEFAULT_SEASON_START_DATE")
	private Date defaultSeasonStartDate ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getDeliveryDateFrom() {
		return deliveryDateFrom;
	}

	public void setDeliveryDateFrom(Date deliveryDateFrom) {
		this.deliveryDateFrom = deliveryDateFrom;
	}

	public Date getDeliveryDateTo() {
		return deliveryDateTo;
	}

	public void setDeliveryDateTo(Date deliveryDateTo) {
		this.deliveryDateTo = deliveryDateTo;
	}

	public Date getOrderDateFrom() {
		return orderDateFrom;
	}

	public void setOrderDateFrom(Date orderDateFrom) {
		this.orderDateFrom = orderDateFrom;
	}

	public Date getOrderDateTo() {
		return orderDateTo;
	}

	public void setOrderDateTo(Date orderDateTo) {
		this.orderDateTo = orderDateTo;
	}

	public String getApprovalNotes() {
		return approvalNotes;
	}

	public void setApprovalNotes(String approvalNotes) {
		this.approvalNotes = approvalNotes;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
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

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public Date getDefaultSeasonStartDate() {
		return defaultSeasonStartDate;
	}

	public void setDefaultSeasonStartDate(Date defaultSeasonStartDate) {
		this.defaultSeasonStartDate = defaultSeasonStartDate;
	}
	
	
}
