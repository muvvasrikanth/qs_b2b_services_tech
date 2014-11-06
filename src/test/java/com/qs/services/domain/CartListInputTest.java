package com.qs.services.domain;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CartListInputTest {
    
	private static final Logger logger = LoggerFactory.getLogger(CartListInputTest.class) ;
	
    @Test
    public void testCartList() throws Exception{
        
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/data/cart.txt");
        String json = IOUtils.toString(resourceAsStream);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        CartList cartList = new CartList();
        Cart cart = new Cart();
		cartList.getCarts().add(cart);
        CartProduct cartProduct = new CartProduct();
        cart.getCartProducts().add(cartProduct);
        CartProductSize cartProductSize = new CartProductSize();
		cartProduct.getCartProductSizes().add(cartProductSize);
		cartProductSize.getCartProductSizeRdds().add(new CartProductSizeRdd());
		String result = ow.writeValueAsString(cartList);
        logger.info("\n\n" + result + "\n\n");
        assertEquals(json, result);
    }
}
