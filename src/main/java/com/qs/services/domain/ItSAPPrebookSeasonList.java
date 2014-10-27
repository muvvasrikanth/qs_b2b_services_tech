package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ItSAPPrebookSeasonList {

	@JsonProperty("IT_PREBOOK_ACTIVE_SEASONS")
	private List<ItPrebookActiveSeason> activeSeasons = new ArrayList<ItPrebookActiveSeason> () ;

	public List<ItPrebookActiveSeason> getActiveSeasons() {
		return activeSeasons;
	}

	public void setActiveSeasons(List<ItPrebookActiveSeason> prebookSeasons) {
		this.activeSeasons = prebookSeasons;
	}
	
	public void addItPrebookActiveSeason(String salesOrg, String season, String collection) {
		this.activeSeasons.add(new ItPrebookActiveSeason(salesOrg, season, collection));
	}
}
