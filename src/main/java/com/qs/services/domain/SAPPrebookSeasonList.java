package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPPrebookSeasonList {

	@JsonProperty("ET_PREBOOK_SEASONS")
	private List<SAPPrebookSeason> prebookSeasons = new ArrayList<SAPPrebookSeason> () ;

    @JsonProperty("ET_RETURN")
    private List etReturn = new ArrayList<>();
    
	public List<SAPPrebookSeason> getPrebookSeasons() {
		return prebookSeasons;
	}

	public void setPrebookSeasons(List<SAPPrebookSeason> prebookSeasons) {
		this.prebookSeasons = prebookSeasons;
	}
	
}
