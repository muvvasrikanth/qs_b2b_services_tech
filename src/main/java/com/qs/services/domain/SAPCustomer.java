package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPCustomer {

	@JsonProperty("ET_SALES_AREA")
	private List <SAPSalesArea> salesAreas = new ArrayList <SAPSalesArea> () ;
	
	@JsonProperty("E_ADDRESS")
	private SAPAddress address ;
	
	@JsonProperty("ET_SHIP_TO_PARTNERS")
	private List <SAPPartner> shipToPartners = new ArrayList <SAPPartner> () ;
	
	@JsonProperty("E_CONTRACT_FLAG")
	private String contractFlag ;
	
	@JsonProperty("E_CLOSE_OUT_FLAG")
	private String closeOutFlag ;
	
	@JsonProperty("E_INVALID_FLAG")
	private String invalidFlag ;
	
	@JsonProperty("E_CCARD_FLAG")
	private String ccardFlag ;
	
	@JsonProperty("E_SOLD_TO")
	private Integer soldTo ;

	@JsonProperty("E_SOLD_TO_CURRENCY")
	private String soldToCurrency ;

	@JsonProperty("ET_RETURN")
	private List <SAPReturn> sapReturns = new ArrayList <SAPReturn> () ;

	@JsonProperty("E_SOLD_TO_NAME")
	private String soldToName ;
	
	public Integer getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(Integer soldTo) {
		this.soldTo = soldTo;
	}

	public String getSoldToName() {
		return soldToName;
	}

	public void setSoldToName(String soldToName) {
		this.soldToName = soldToName;
	}

	public String getSoldToCurrency() {
		return soldToCurrency;
	}

	public void setSoldToCurrency(String soldToCurrency) {
		this.soldToCurrency = soldToCurrency;
	}

	public String getContractFlag() {
		return contractFlag;
	}

	public void setContractFlag(String contractFlag) {
		this.contractFlag = contractFlag;
	}

	public String getCloseOutFlag() {
		return closeOutFlag;
	}

	public void setCloseOutFlag(String closeOutFlag) {
		this.closeOutFlag = closeOutFlag;
	}

	public String getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(String invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public String getCcardFlag() {
		return ccardFlag;
	}

	public void setCcardFlag(String ccardFlag) {
		this.ccardFlag = ccardFlag;
	}

	public List<SAPSalesArea> getSalesAreas() {
		return salesAreas;
	}

	public void setSalesAreas(List<SAPSalesArea> salesAreas) {
		this.salesAreas = salesAreas;
	}

	public SAPAddress getAddress() {
		return address;
	}

	public void setAddress(SAPAddress address) {
		this.address = address;
	}

	public List<SAPPartner> getShipToPartners() {
		return shipToPartners;
	}

	public void setShipToPartners(List<SAPPartner> shipToPartners) {
		this.shipToPartners = shipToPartners;
	}

	public List<SAPReturn> getSapReturns() {
		return sapReturns;
	}

	public void setSapReturns(List<SAPReturn> sapReturns) {
		this.sapReturns = sapReturns;
	}


}
