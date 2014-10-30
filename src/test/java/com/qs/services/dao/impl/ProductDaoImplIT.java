package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.dao.ProductDao;
import com.qs.services.domain.Product;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoImplIT extends AbstractJUnit4SpringContextTests {

	@Autowired
	private ProductDao dao ;
	
	@Test
	public void testAutowiring() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGetHeroImage(){
		String urlStr = dao.getMediumHeroImageUrl(mockProduct()) ;
		assertNotNull(urlStr) ;
		assertEquals("https://d22s0gjkad48ui.cloudfront.net/products/12/102812/102812_BKS0_FRT1_420-560.JPG", urlStr) ;
		
	}
	
	private Product mockProduct(){
		Product p = new Product() ;
		p.setProduct("102812-BKS0");
		return p ;
	}
}
