package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartProductSizeList {

	@JsonProperty("ET_CART_PRODUCT_SIZE")
	private List<CartProductSize> cartProductSizes = new ArrayList<CartProductSize>() ;

	public List<CartProductSize> getCartProductSizes() {
		return cartProductSizes;
	}

	public void setCartProductSizes(List<CartProductSize> cartProductSizes) {
		this.cartProductSizes = cartProductSizes;
	}
	
	
}
