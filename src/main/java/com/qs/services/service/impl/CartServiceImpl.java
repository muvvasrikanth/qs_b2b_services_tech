package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.CartHeader;
import com.qs.services.domain.Cart;
import com.qs.services.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao ;

	@Transactional
	public void insertCarts(Cart cart) {
		Integer cartId = dao.insertCartHeader(cart.getCartHeader());
		dao.insertCartProducts(cart.getCartProducts(), cartId);
		dao.insertCartProductSizeRdds(cart.getCartProductSizeRdds());
		dao.insertCartProductSizes(cart.getCartProductSizes());
	}

}
