package com.qs.services.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartList;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao ;

	@Transactional
	public void insertCarts(CartList cartList) {
		for (Cart cart : cartList.getCarts()) {
			this.insertCart(cart);
		}
	}

	private void insertCart(Cart cart) {
		Integer cartId = dao.insertCartHeader(cart);
		
		List<Map<String, String>> cartProducts = dao.insertCartProducts(cart.getCartProducts(), cartId);
		
		for (CartProduct cp : cart.getCartProducts()) {
			dao.insertCartProductSizes(cp.getCartProductSizes());
			for (CartProductSize cps : cp.getCartProductSizes()) {
				dao.insertCartProductSizeRdds(cps.getCartProductSizeRdds());
			}
		}
	}

}
