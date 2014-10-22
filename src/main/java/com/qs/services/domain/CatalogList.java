package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class CatalogList {
	
	private List<Catalog> catalogs = new ArrayList <Catalog>() ;

}
