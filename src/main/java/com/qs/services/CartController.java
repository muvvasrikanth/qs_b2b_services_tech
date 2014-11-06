package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.CartList;
import com.qs.services.domain.DataResult;
import com.qs.services.service.CartService;
import com.qs.services.util.ServiceUtil;

@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService service ;
	
	@RequestMapping(value = "/carts", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public DataResult saveCarts(@RequestBody CartList cartList, HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		logger.info("Call to sync carts.");
		
		service.insertCarts(cartList) ;
		return ServiceUtil.successResult("");
	}
	
}
