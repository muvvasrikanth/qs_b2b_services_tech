package com.qs.services.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;

@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	private DataSource dataSource ;
	
	@Autowired
	private JdbcTemplate template ;
	
	@Override
	public void insertCart(Cart cart) {
		//TODO finish the code to create a cart.
	}

}
