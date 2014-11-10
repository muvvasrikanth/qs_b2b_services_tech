package com.qs.services.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.CartList;

public interface CartService {

	public void insertCarts(CartList cartList) throws JsonGenerationException, JsonMappingException, IOException;
	
}
