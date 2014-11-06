package com.qs.services.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

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
        cart.getCartProducts().add(cartProduct);
        CartProductSize cartProductSize = new CartProductSize();
		cartProduct.getCartProductSizes().add(cartProductSize);
		cartProductSize.getCartProductSizeRdds().add(new CartProductSizeRdd());

		when((dao).insertCartHeader(cart)).thenReturn(1);
		
		service.insertCarts(cartList);
		verify(dao).insertCartHeader(cart);
		verify(dao).insertCartProducts(cart.getCartProducts(), 1);
		verify(dao).insertCartProductSizes(cartProduct.getCartProductSizes());
		verify(dao).insertCartProductSizeRdds(cartProductSize.getCartProductSizeRdds());
	}

}
