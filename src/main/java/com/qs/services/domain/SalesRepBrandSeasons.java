package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SalesRepBrandSeasons {

	@JsonProperty("I_SALES_REP")
	private String salesRep ;
	
	@JsonProperty("I_SINCE")
	private String since ;
	
	@JsonProperty("IT_BRAND_SEASONS")
	private List<BrandSeason> brandSeasons = new ArrayList<BrandSeason>() ;

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public String getSince() {
		return since;
	}

	public void setSince(String since) {
		this.since = since;
	}

	public List<BrandSeason> getBrandSeasons() {
		return brandSeasons;
	}

	public void setBrandSeasons(List<BrandSeason> brandSeasons) {
		this.brandSeasons = brandSeasons;
	}
}

