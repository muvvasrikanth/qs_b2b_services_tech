package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProductSizeRddList {

	@JsonProperty("ET_CART_PRODUCT_SIZE_RDD")
	private List<CartProductSizeRdd> cartProductSizeRdds = new ArrayList<CartProductSizeRdd>() ;

	public List<CartProductSizeRdd> getCartProductSizeRdds() {
		return cartProductSizeRdds;
	}

	public void setCartProductSizeRdds(List<CartProductSizeRdd> cartProductSizeRdds) {
		this.cartProductSizeRdds = cartProductSizeRdds;
	}
	
	
}
