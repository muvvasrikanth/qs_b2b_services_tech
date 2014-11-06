package com.qs.services.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProduct {

	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("DRAFT_SALESDOC_HEADER_ID")
	private Integer draftSalesDocHeaderId ;
	
	@JsonProperty("PRODUCT_NUMBER")
	private String productNumber ;
	
	@JsonProperty("GENDER_FIT")
	private String genderFit ;
	
	@JsonProperty("STYLE")
	private String style ;
	
	@JsonProperty("CREATEDBY")
	private String createdBy ;
	
	@JsonProperty("CREATEDDATETIME")
	private Date createdDateTime ;
	
	@JsonProperty("MODIFIEDBY")
	private String modifiedBy ;
	
	@JsonProperty("MODIFIEDDATETIME")
	private Date modifiedDateTime ;
	
	@JsonProperty("DIMENSION")
	private String dimenison ;
	
	@JsonProperty("RDD")
	private Date requestedDeliveryDate ;
	
	@JsonProperty("UOM")
	private String unitOfMeasure ;
	
	@JsonProperty("LINE_ITEM_NO")
	private String lineItemNo ;
	
	@JsonProperty("DLV_GROUP")
	private String dlvGroup ;
	
	@JsonProperty("AUTOALLOCATION")
	private Boolean autoAllocation ;
	
	@JsonProperty("BRAND")
	private String brand ;
	
	@JsonProperty("SALES_ORG")
	private String salesOrg ;
	
	@JsonProperty("DISTRIBUTION_CHANNEL")
	private String distrubutionChannel ;
	
	@JsonProperty("SEASON")
	private String season ;
	
	@JsonProperty("SEQUENCE")
	private Double sequence ;
	
	@JsonProperty("BASE_PRICE")
	private Double basePrice ;
	
	@JsonProperty("MSRP_PRICE")
	private Double msrpPrice ;
	
	@JsonProperty("MAP_PRICE")
	private Double mapPrice ;
	
	@JsonProperty("NET_PRICE")
	private Double netPrice ;
	
	@JsonProperty("DISCOUNT")
	private Double discount ;
	
	@JsonProperty("DISCOUNT_PERCENT")
	private Double discountPercent ;
	
	@JsonProperty("QUANTITIES")
	private Integer quantities ;
	
	@JsonProperty("TOTAL_BASE_PRICE")
	private Double totalBasePrice ;
	
	@JsonProperty("TOTAL_MSRP_PRICE")
	private Double totalMsrpPrice ;
	
	@JsonProperty("TOTAL_MAP_PRICE")
	private Double totalMapPrice ;
	
	@JsonProperty("TOTAL_NET_PRICE")
	private Double totalNetPrice ;

	@JsonProperty("ET_CART_PRODUCT_SIZE")
	private List<CartProductSize> cartProductSizes = new ArrayList<CartProductSize>() ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDraftSalesDocHeaderId() {
		return draftSalesDocHeaderId;
	}

	public void setDraftSalesDocHeaderId(Integer draftSalesDocHeaderId) {
		this.draftSalesDocHeaderId = draftSalesDocHeaderId;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getGenderFit() {
		return genderFit;
	}

	public void setGenderFit(String genderFit) {
		this.genderFit = genderFit;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public String getDimenison() {
		return dimenison;
	}

	public void setDimenison(String dimenison) {
		this.dimenison = dimenison;
	}

	public Date getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(Date requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getLineItemNo() {
		return lineItemNo;
	}

	public void setLineItemNo(String lineItemNo) {
		this.lineItemNo = lineItemNo;
	}

	public String getDlvGroup() {
		return dlvGroup;
	}

	public void setDlvGroup(String dlvGroup) {
		this.dlvGroup = dlvGroup;
	}

	public Boolean getAutoAllocation() {
		return autoAllocation;
	}

	public void setAutoAllocation(Boolean autoAllocation) {
		this.autoAllocation = autoAllocation;
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

	public String getDistrubutionChannel() {
		return distrubutionChannel;
	}

	public void setDistrubutionChannel(String distrubutionChannel) {
		this.distrubutionChannel = distrubutionChannel;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Double getSequence() {
		return sequence;
	}

	public void setSequence(Double sequence) {
		this.sequence = sequence;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Double getMsrpPrice() {
		return msrpPrice;
	}

	public void setMsrpPrice(Double msrpPrice) {
		this.msrpPrice = msrpPrice;
	}

	public Double getMapPrice() {
		return mapPrice;
	}

	public void setMapPrice(Double mapPrice) {
		this.mapPrice = mapPrice;
	}

	public Double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getQuantities() {
		return quantities;
	}

	public void setQuantities(Integer quantities) {
		this.quantities = quantities;
	}

	public Double getTotalBasePrice() {
		return totalBasePrice;
	}

	public void setTotalBasePrice(Double totalBasePrice) {
		this.totalBasePrice = totalBasePrice;
	}

	public Double getTotalMsrpPrice() {
		return totalMsrpPrice;
	}

	public void setTotalMsrpPrice(Double totalMsrpPrice) {
		this.totalMsrpPrice = totalMsrpPrice;
	}

	public Double getTotalMapPrice() {
		return totalMapPrice;
	}

	public void setTotalMapPrice(Double totalMapPrice) {
		this.totalMapPrice = totalMapPrice;
	}

	public Double getTotalNetPrice() {
		return totalNetPrice;
	}

	public void setTotalNetPrice(Double totalNetPrice) {
		this.totalNetPrice = totalNetPrice;
	}
	
	public List<CartProductSize> getCartProductSizes() {
		return cartProductSizes;
	}

	public void setCartProductSizes(List<CartProductSize> cartProductSizes) {
		this.cartProductSizes = cartProductSizes;
	}
	
}
