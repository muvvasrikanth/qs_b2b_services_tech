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
import com.qs.services.domain.CartProductSizeRdd;
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
		
		List<Map<String, String>> cartProductsIDs = dao.insertCartProducts(cart.getCartProducts(), cartId);
		
		for (CartProduct cp : cart.getCartProducts()) {
			Integer prodId = null;
			for (Map<String, String> cartProdIDs : cartProductsIDs) {
				if (cp.getProductNumber().equals(cartProdIDs.get("product_number"))) {
					prodId = Integer.valueOf(cartProdIDs.get("id"));
					break;
				}
			}
			for (CartProductSize cps : cp.getCartProductSizes()) {
				cps.setSalesDocProductId(prodId);
			}
			List<Map<String, String>> cartProductSizesIDs = dao.insertCartProductSizes(cp.getCartProductSizes());

			saveProductSizeRdds(cp.getCartProductSizes(), cartProductSizesIDs);
		}
	}

	private void saveProductSizeRdds(List<CartProductSize> cartProductSizes, List<Map<String, String>> cartProductSizesIDs) {
		for (CartProductSize cps : cartProductSizes) {
			Integer prodSizeId = null;
			for (Map<String, String> cartProdIDs : cartProductSizesIDs) {
				if (cps.getSalesDocProductId().toString().equals(cartProdIDs.get("salesdoc_product_id"))) {
					prodSizeId = Integer.valueOf(cartProdIDs.get("id"));
					break;
				}
			}
			
			List<CartProductSizeRdd> cartProductSizeRdds = cps.getCartProductSizeRdds();
			for (CartProductSizeRdd cpsrdd : cartProductSizeRdds) {
				cpsrdd.setProductSizeId(prodSizeId);
			}
			dao.insertCartProductSizeRdds(cartProductSizeRdds);
		}
	}

}
