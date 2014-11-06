package com.qs.services.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qs.services.domain.Cart;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;

public interface CartDao  {

	public Integer insertCartHeader(Cart cart) ;
	
	public List<Map<String, String>> insertCartProducts(List<CartProduct> cartProducts, Integer cartId) ;
	
	public List<Map<String, String>> insertCartProductSizes(List<CartProductSize> cartProductSizes) ;
	
	public List<Map<String, String>> insertCartProductSizeRdds(List<CartProductSizeRdd> cartProductSizeRdds) ;
}
