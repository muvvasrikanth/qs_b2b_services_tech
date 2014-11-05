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
        
        ObjectWriter ow = new ObjectMapper().writer();
        Cart cartList = new Cart();
        cartList.getCartProducts().add(new CartProduct());
        cartList.getCartProductSizeRdds().add(new CartProductSizeRdd());
        cartList.getCartProductSizes().add(new CartProductSize());
        cartList.setCartHeader(new CartHeader());
		String result = ow.writeValueAsString(cartList);
        logger.info("\n\n" + result + "\n\n");
        assertEquals(json, result);
    }
}
