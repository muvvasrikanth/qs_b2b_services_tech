package com.qs.services.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.Cart;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;

public interface CartDao  {

	public Integer insertCartHeader(Cart cart) ;
	
	public Integer insertCartProduct(CartProduct product, Integer cartId) throws JsonGenerationException, JsonMappingException, IOException ;
	
	public Integer insertCartProductSize(CartProductSize cartProductSize) ;
	
	public Integer insertCartProductSizeRdd(CartProductSizeRdd cartProductSizeRdd) ;
}
