package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.service.CartService;

@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService service ;
	
	@RequestMapping(value = "/carts", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
//	public String saveCarts(@RequestBody Cart cart, HttpServletRequest request, 
//			HttpServletResponse response) throws IOException{
	public String saveCarts(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		logger.info("Call to sync carts.");
		
//		service.insertCart(cart) ;
		return "{\"success\":\"true\"}";
	}
	
}
