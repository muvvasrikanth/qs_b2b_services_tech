package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CartListInput {

	@JsonProperty("ET_CART")
	private List<Cart> carts = new ArrayList<Cart>() ;
	
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
	
	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	
}
