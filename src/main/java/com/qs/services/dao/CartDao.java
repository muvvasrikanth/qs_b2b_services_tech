package com.qs.services.dao;

import com.qs.services.domain.Cart;
import com.qs.services.domain.CartProductList;
import com.qs.services.domain.CartProductSizeList;
import com.qs.services.domain.CartProductSizeRddList;

public interface CartDao  {

	public void insertCart(Cart cart, CartProductList cartProductList, CartProductSizeList cartProductSizeList, CartProductSizeRddList cartProductSizeRddList) ;
	
}
