package com.qs.services.domain;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ProductSize {

	@JsonProperty("SIZE_GRID") 
	private String sizeGrid ;
	
	@JsonProperty("SIZE") 
	private String size ;
	
	@JsonProperty("SEQUENCE") 
	private Integer sequence ;
	
	@JsonProperty("DESCRIPTION") 
	private String description ;

	public String getSizeGrid() {
		return sizeGrid;
	}

	public void setSizeGrid(String sizeGrid) {
		this.sizeGrid = sizeGrid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
