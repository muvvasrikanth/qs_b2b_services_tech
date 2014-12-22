package com.qs.services.util;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class) ;
	
	public static String normalize(String s) throws UnsupportedEncodingException{
		s = Normalizer.normalize(s, Normalizer.Form.NFKD) ;
		Pattern pattern = Pattern.compile("[\\p{InCombiningDiacriticalMarks}+]");
		s = pattern.matcher(s).replaceAll("") ;
		logger.info(s);
		return s ;
	}
	
}
