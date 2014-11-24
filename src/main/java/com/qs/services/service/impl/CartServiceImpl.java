package com.qs.services.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartList;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;
import com.qs.services.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {
	
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class) ;
	
	@Autowired
	private CartDao dao ;

	@Transactional
	public void insertCarts(CartList cartList) throws JsonGenerationException, JsonMappingException, IOException {
		for (Cart cart : cartList.getCarts()) {
			this.insertCart(cart);
		}
	}

	private void insertCart(Cart cart) throws JsonGenerationException, JsonMappingException, IOException {
		cart = calculateQuantities(cart) ;
		logger.info(new ObjectMapper().writeValueAsString(cart));
		Integer cartId = dao.insertCartHeader(cart), cartProductId, cartProductSizeId, cartProductSizeRddId ;
		logger.info("Created new Cart [" + cartId + "]") ;
		for(CartProduct cp : cart.getCartProducts()){
			cartProductId = dao.insertCartProduct(cp, cartId) ;
			logger.info("Created new Cart Product [" + cartProductId + "]");
			for(CartProductSize cps : cp.getCartProductSizes()){
				cps.setSalesDocProductId(cartProductId);
				cartProductSizeId = dao.insertCartProductSize(cps) ;
				logger.info("Created new Cart Product Size [" + cartProductSizeId + "]");
				for(CartProductSizeRdd cpsr : cps.getCartProductSizeRdds()){
					cpsr.setProductSizeId(cartProductSizeId);
					
					cartProductSizeRddId = dao.insertCartProductSizeRdd(cpsr) ;
					logger.info("Created new Cart Product Size RDD [" + cartProductSizeRddId + "]");
				}
			}
		}
	}

	private Cart calculateQuantities(Cart cart) {
		
		CartProduct cp = null ;
		CartProductSize cps = null ;
		CartProductSizeRdd cpsr = null ;
		
		for(int i=0; i<cart.getCartProducts().size(); i++){
			cp = cart.getCartProducts().get(i) ;
			for(int j=0; j<cart.getCartProducts().get(i).getCartProductSizes().size(); j++){
				cps = cart.getCartProducts().get(i).getCartProductSizes().get(j) ;
				for(int h=0; h<cart.getCartProducts().get(i).getCartProductSizes().get(j).getCartProductSizeRdds().size(); h++){
					cpsr = cart.getCartProducts().get(i).getCartProductSizes().get(j).getCartProductSizeRdds().get(h) ;
					cart.getCartProducts().get(i).getCartProductSizes().get(j).setQuantity(cps.getQuantity()+cpsr.getQuantity());
				}
				cart.getCartProducts().get(i).setQuantities(cp.getQuantities()+cps.getQuantity());
			}
			cart.setTotalQuantities(cart.getTotalQuantities()+cp.getQuantities());
		}
		
		return cart ;
	}
	
	
}
