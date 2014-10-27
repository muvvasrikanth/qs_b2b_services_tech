package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ProductSalesArea {

	@JsonProperty("PRODUCT")
    private String product;

    @JsonProperty("SALES_ORG")
    private String salesOrg;

    @JsonProperty("DISTRIBUTION_CHANNEL")
    private String distributionChannel;

    @JsonProperty("SELLING_GROUP")
    private String sellingGrp;

    @JsonProperty("MATERIAL_COLLECTION")
    private String materialCol;

    @JsonProperty("SEGMENT")
    private String segment;
    
    @JsonProperty("MARKET_CLASSIFICATION")
    private String marketClassification;
    
    @JsonProperty("SIZE_GRID")
    private String sizeGrid;
    
    @JsonProperty("SEQUENCE")
    private String sequence;
    
    public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public String getSellingGrp() {
		return sellingGrp;
	}

	public void setSellingGrp(String sellingGrp) {
		this.sellingGrp = sellingGrp;
	}

	public String getMaterialCol() {
		return materialCol;
	}

	public void setMaterialCol(String materialCol) {
		this.materialCol = materialCol;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getMarketClassification() {
		return marketClassification;
	}

	public void setMarketClassification(String marketClassification) {
		this.marketClassification = marketClassification;
	}

	public String getSizeGrid() {
		return sizeGrid;
	}

	public void setSizeGrid(String sizeGrid) {
		this.sizeGrid = sizeGrid;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
}
