package com.qs.services.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartProductList;
import com.qs.services.domain.CartProductSizeList;
import com.qs.services.domain.CartProductSizeRddList;

@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	private DataSource dataSource ;
	
	@Autowired
	private JdbcTemplate template ;
	
	@Override
	public void insertCart(Cart cart, CartProductList cartProductList, CartProductSizeList cartProductSizeList, CartProductSizeRddList cartProductSizeRddList) {
		// TODO finish the code for this method
		/*
		 * Pseudo-code
		 * 
		 * 1) Begin transaction
		 * 2) Write Cart (sales doc header)
		 * 3) Write Cart Products (sales doc products)
		 * 4) Write Cart Product Sizes (sales doc product sizes)
		 * 5) Write Cart Product Size RDDs (sales doc product size rdds)
		 * 6) If an error is thrown above roll back the transaction
		 * 7) Commit the transaction
		 * 
		 */
	}

}
