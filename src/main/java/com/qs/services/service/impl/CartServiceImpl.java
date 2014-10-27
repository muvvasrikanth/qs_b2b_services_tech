package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao ;

	@Override
	public void insertCart(Cart cart) {
//		dao.insertCart(cart);
	}

}
