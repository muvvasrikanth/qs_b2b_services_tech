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

import com.qs.services.service.SecurityService;

/**
 * 
 * @author jtryon
 *
 */
@Controller
public class SecurityController {

	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class) ;
	
	@Autowired
	private SecurityService service ;
	
	/**
	 * Refactor to return a serializable token
	 * @return
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public Boolean authenticate(HttpServletRequest request, HttpServletResponse response){
		logger.info(getClass().getSimpleName() + ".authenticate(...)");
		
		try{
			String auth = request.getParameter("x-auth") ;
			logger.info("x-auth:" + auth);
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		} catch(IOException e){
			logger.error(e.getMessage(), e) ;
		}
		 
		return true ;
	}
	
	// add another end point to take a token and the password for the user
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public void post(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/authenticate", method = RequestMethod.PUT)
	public void put(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/authenticate", method = RequestMethod.DELETE)
	public void delete(HttpServletRequest request, HttpServletResponse response){
		try {
			response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
