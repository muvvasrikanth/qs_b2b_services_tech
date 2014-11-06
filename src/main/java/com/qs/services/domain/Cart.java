package com.qs.services.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Cart {
	
	@JsonProperty("DRAFT_SALESDOC_HEADER_ID")
	private Integer drafSalesDocHeaderId ;

	@JsonProperty("DOC_CATEGORY_ID")
	private Integer docCatagoryId ;

	@JsonProperty("METHOD_CODE_ID")
	private Integer methodCodeId ;

	@JsonProperty("CUSTOMER_NUMBER")
	private String customerNumber ;

	@JsonProperty("SHIP_TO_NUMBER")
	private String shipToNumber ;

	@JsonProperty("SALES_DOC_NAME")
	private String salesDocName ;

	@JsonProperty("CUSTOMER_PO_NUMBER")
	private String customerPoNumber ;

	@JsonProperty("REQUESTED_DELIVERY_DT")
	private Date requestedDeliveryDt ;

	@JsonProperty("CANCEL_DT")
	private Date cancelDt ;

	@JsonProperty("READYFORSUBMISSION_VALUE")
	private String readyForSubmissionValue ;

	@JsonProperty("DRAFTSALESDOC_STATUS_ID")
	private Integer draftSalesDocStatusId ;

	@JsonProperty("EXTENAL_STATUS")
	private String externalStatus ;

	@JsonProperty("INTERNAL_STATUS")
	private String internalStatus ;

	@JsonProperty("SHARED")
	private String shared ;

	@JsonProperty("REFERENCE_DOCUMENT_NUMBER")
	private String referenceDocumentNumber ;

	@JsonProperty("IDOC_NUMBER")
	private String iDocNumber ;

	@JsonProperty("LATEST_IDOC_NUMBER")
	private String latestIDocNumber ;

	@JsonProperty("SAP_ORDER_NUMBER")
	private String sapOrderNumber ;

	@JsonProperty("CREATED_BY")
	private String createdBy ;

	@JsonProperty("CREATED_ON")
	private Date createdOn ;

	@JsonProperty("LAST_UPDATE_BY")
	private String lastUpdateBy ;

	@JsonProperty("LAST_UPDATE_ON")
	private Date lastUpdateOn ;

	@JsonProperty("NOTES")
	private String notes ;

	@JsonProperty("VALID_FROM")
	private Date validFrom ;

	@JsonProperty("VALID_TO")
	private Date validTo ;

	@JsonProperty("SHIPPING_INSTRUCTION")
	private String shippingInstructions ;

	@JsonProperty("CARRIER_NAME")
	private String carrierName ;

	@JsonProperty("CARRIER_ACNO")
	private String carrierAcno ;

	@JsonProperty("EXCEL_PATH")
	private String excelPath ;

	@JsonProperty("EXCEL_FILE_NAME")
	private String excelFileName ;

	@JsonProperty("DOC_TYPE_ID")
	private String docTypeId ;

	@JsonProperty("ORDER_CONTEXT")
	private String orderContext ;

	@JsonProperty("SEASON")
	private String season ;

	@JsonProperty("REASON")
	private String reason ;

	@JsonProperty("UNITS")
	private Integer units ;

	@JsonProperty("TOTAL_QUANTITIES")
	private Integer totalQuantities ;

	@JsonProperty("TOTAL_BASE_PRICE")
	private Double totalBasePrice ;

	@JsonProperty("TOTAL_MSRP_PRICE")
	private Double totalMsrpPrice ;

	@JsonProperty("TOTAL_MAP_PRICE")
	private Double totalMapPrice ;

	@JsonProperty("TOTAL_NET_PRICE")
	private Double totalNetPrice ;

	@JsonProperty("DELTA_FLAG")
	private Boolean deltaFlag ;

	@JsonProperty("SUBMITTED_CART_ID")
	private String submittedCartId ;

	@JsonProperty("ET_CART_PRODUCT")
	private List<CartProduct> cartProducts = new ArrayList<CartProduct>() ;

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public Integer getDrafSalesDocHeaderId() {
		return drafSalesDocHeaderId;
	}

	public void setDrafSalesDocHeaderId(Integer drafSalesDocHeaderId) {
		this.drafSalesDocHeaderId = drafSalesDocHeaderId;
	}

	public Integer getDocCatagoryId() {
		return docCatagoryId;
	}

	public void setDocCatagoryId(Integer docCatagoryId) {
		this.docCatagoryId = docCatagoryId;
	}

	public Integer getMethodCodeId() {
		return methodCodeId;
	}

	public void setMethodCodeId(Integer methodCodeId) {
		this.methodCodeId = methodCodeId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getShipToNumber() {
		return shipToNumber;
	}

	public void setShipToNumber(String shipToNumber) {
		this.shipToNumber = shipToNumber;
	}

	public String getSalesDocName() {
		return salesDocName;
	}

	public void setSalesDocName(String salesDocName) {
		this.salesDocName = salesDocName;
	}

	public String getCustomerPoNumber() {
		return customerPoNumber;
	}

	public void setCustomerPoNumber(String customerPoNumber) {
		this.customerPoNumber = customerPoNumber;
	}

	public Date getRequestedDeliveryDt() {
		return requestedDeliveryDt;
	}

	public void setRequestedDeliveryDt(Date requestedDeliveryDt) {
		this.requestedDeliveryDt = requestedDeliveryDt;
	}

	public Date getCancelDt() {
		return cancelDt;
	}

	public void setCancelDt(Date cancelDt) {
		this.cancelDt = cancelDt;
	}

	public String getReadyForSubmissionValue() {
		return readyForSubmissionValue;
	}

	public void setReadyForSubmissionValue(String readyForSubmissionValue) {
		this.readyForSubmissionValue = readyForSubmissionValue;
	}

	public Integer getDraftSalesDocStatusId() {
		return draftSalesDocStatusId;
	}

	public void setDraftSalesDocStatusId(Integer draftSalesDocStatusId) {
		this.draftSalesDocStatusId = draftSalesDocStatusId;
	}

	public String getExternalStatus() {
		return externalStatus;
	}

	public void setExternalStatus(String externalStatus) {
		this.externalStatus = externalStatus;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	public String getShared() {
		return shared;
	}

	public void setShared(String shared) {
		this.shared = shared;
	}

	public String getReferenceDocumentNumber() {
		return referenceDocumentNumber;
	}

	public void setReferenceDocumentNumber(String referenceDocumentNumber) {
		this.referenceDocumentNumber = referenceDocumentNumber;
	}

	public String getiDocNumber() {
		return iDocNumber;
	}

	public void setiDocNumber(String iDocNumber) {
		this.iDocNumber = iDocNumber;
	}

	public String getLatestIDocNumber() {
		return latestIDocNumber;
	}

	public void setLatestIDocNumber(String latestIDocNumber) {
		this.latestIDocNumber = latestIDocNumber;
	}

	public String getSapOrderNumber() {
		return sapOrderNumber;
	}

	public void setSapOrderNumber(String sapOrderNumber) {
		this.sapOrderNumber = sapOrderNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateOn() {
		return lastUpdateOn;
	}

	public void setLastUpdateOn(Date lastUpdateOn) {
		this.lastUpdateOn = lastUpdateOn;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public String getShippingInstructions() {
		return shippingInstructions;
	}

	public void setShippingInstructions(String shippingInstructions) {
		this.shippingInstructions = shippingInstructions;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierAcno() {
		return carrierAcno;
	}

	public void setCarrierAcno(String carrierAcno) {
		this.carrierAcno = carrierAcno;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getDocTypeId() {
		return docTypeId;
	}

	public void setDocTypeId(String docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getOrderContext() {
		return orderContext;
	}

	public void setOrderContext(String orderContext) {
		this.orderContext = orderContext;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Integer getTotalQuantities() {
		return totalQuantities;
	}

	public void setTotalQuantities(Integer totalQuantities) {
		this.totalQuantities = totalQuantities;
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

	public Boolean getDeltaFlag() {
		return deltaFlag;
	}

	public void setDeltaFlag(Boolean deltaFlag) {
		this.deltaFlag = deltaFlag;
	}

	public String getSubmittedCartId() {
		return submittedCartId;
	}

	public void setSubmittedCartId(String submittedCartId) {
		this.submittedCartId = submittedCartId;
	}
}
