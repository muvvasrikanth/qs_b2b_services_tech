package com.qs.services.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QSBasicAuthFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(QSBasicAuthFilter.class) ;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		String key = null, value = null ;
		while(request.getParameterNames().hasMoreElements()){
			key = (String) request.getParameterNames().nextElement() ;
			value = (String) request.getParameter(key) ;
			if(logger.isDebugEnabled()){logger.debug("Parameter [" + key + "]= " + value);}
		}
		
		HttpServletRequest httpRequest = (HttpServletRequest) request ;
		while(httpRequest.getHeaderNames().hasMoreElements()){
			key = (String) httpRequest.getHeaderNames().nextElement() ;
			value = httpRequest.getHeader(key).toString();
			if(logger.isDebugEnabled()){logger.debug("Header [" + key + "]= " + value);}
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
