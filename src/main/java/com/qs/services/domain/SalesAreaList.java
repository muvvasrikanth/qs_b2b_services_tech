package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SalesAreaList {

	@JsonProperty("ET_SALES_AREAS")
	private List<SalesArea> salesAreas = new ArrayList<SalesArea>() ;

	public List<SalesArea> getSalesAreas() {
		return salesAreas;
	}

	public void setSalesAreas(List<SalesArea> salesAreas) {
		this.salesAreas = salesAreas;
	}
	
	
}
