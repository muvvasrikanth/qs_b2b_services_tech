package com.qs.services.util;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(StringUtilTest.class) ;
	@Test
	public void testNormalize() throws UnsupportedEncodingException {
		String src = "accessoires rentrיe des classes" ;
		String srcNFKD = StringUtil.normalize(src) ;
		logger.info(srcNFKD);
	}
	
	@Test
	public void testReallyBad() throws UnsupportedEncodingException{
		String src="üןצהכמפûגךתםףבישלעאט001" ;
		String norm = StringUtil.normalize(src) ;
		logger.info(norm);
	}

}
