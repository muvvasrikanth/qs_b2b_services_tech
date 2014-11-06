package com.qs.services.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartList;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;
import com.qs.services.service.impl.CartServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CartService service = new CartServiceImpl() ;
	
	@Mock
	private CartDao dao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testInsertCart() {
        CartList cartList = new CartList();
        Cart cart = new Cart();
		cartList.getCarts().add(cart);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductNumber("prod#1");
        cart.getCartProducts().add(cartProduct);
        CartProductSize cartProductSize = new CartProductSize();
		cartProduct.getCartProductSizes().add(cartProductSize);
		CartProductSizeRdd cartProductSizeRdd = new CartProductSizeRdd();
		cartProductSize.getCartProductSizeRdds().add(cartProductSizeRdd);

		List<Map<String,String>> cartProds = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", "6");
		map.put("product_number", "prod#1");
		cartProds.add(map);
		when((dao).insertCartHeader(cart)).thenReturn(1);
		when((dao).insertCartProducts(cart.getCartProducts(), 1)).thenReturn(cartProds);
		
		List<Map<String,String>> cartProdSizes = new ArrayList<Map<String,String>>();
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("id", "103");
		map2.put("salesdoc_product_id", "6");
		cartProdSizes.add(map2);
		when((dao).insertCartProductSizes(cartProduct.getCartProductSizes())).thenReturn(cartProdSizes);
		
		service.insertCarts(cartList);
		
		assertEquals(new Integer(6), cartProductSize.getSalesDocProductId());
		assertEquals(new Integer(103), cartProductSizeRdd.getProductSizeId());
		
		verify(dao).insertCartHeader(cart);
		verify(dao).insertCartProducts(cart.getCartProducts(), 1);
		verify(dao).insertCartProductSizes(cartProduct.getCartProductSizes());
		verify(dao).insertCartProductSizeRdds(cartProductSize.getCartProductSizeRdds());
	}

}
