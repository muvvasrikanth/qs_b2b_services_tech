package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Cart {

	@JsonProperty("ET_CART")
	private CartHeader cartHeader = null;

	@JsonProperty("ET_CART_PRODUCT")
	private List<CartProduct> cartProducts = new ArrayList<CartProduct>() ;

	@JsonProperty("ET_CART_PRODUCT_SIZE")
	private List<CartProductSize> cartProductSizes = new ArrayList<CartProductSize>() ;

	@JsonProperty("ET_CART_PRODUCT_SIZE_RDD")
	private List<CartProductSizeRdd> cartProductSizeRdds = new ArrayList<CartProductSizeRdd>() ;

	public List<CartProductSizeRdd> getCartProductSizeRdds() {
		return cartProductSizeRdds;
	}

	public void setCartProductSizeRdds(List<CartProductSizeRdd> cartProductSizeRdds) {
		this.cartProductSizeRdds = cartProductSizeRdds;
	}
	public List<CartProductSize> getCartProductSizes() {
		return cartProductSizes;
	}

	public void setCartProductSizes(List<CartProductSize> cartProductSizes) {
		this.cartProductSizes = cartProductSizes;
	}
	
	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public CartHeader getCartHeader() {
		return cartHeader;
	}

	public void setCartHeader(CartHeader cartHeader) {
		this.cartHeader = cartHeader;
	}

}
