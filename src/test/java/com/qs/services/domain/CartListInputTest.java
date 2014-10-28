package com.qs.services.domain;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CartListInputTest {
    
    @Test
    public void testCartList() throws Exception{
        
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/cartListInput.txt");
        String json = IOUtils.toString(resourceAsStream);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        CartListInput cartList = new CartListInput();
        cartList.getCartProducts().add(new CartProduct());
        cartList.getCartProductSizeRdds().add(new CartProductSizeRdd());
        cartList.getCartProductSizes().add(new CartProductSize());
        cartList.getCarts().add(new Cart());
		String result = ow.writeValueAsString(cartList);
        
        assertEquals(json, result);
        
    }

}
