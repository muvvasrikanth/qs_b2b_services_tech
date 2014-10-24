package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class SAPPrebookSeasonList {

	@JsonProperty("")
	private List<SAPPrebookSeason> prebookSeasons = new ArrayList<SAPPrebookSeason> () ;
	
}
