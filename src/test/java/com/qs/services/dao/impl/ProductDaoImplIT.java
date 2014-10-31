package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		Map<String, String> imageUrls = dao.getMediumHeroImageUrls(mockProductList()) ;
		assertNotNull(imageUrls) ;
		logger.info(imageUrls);
	}
	
	private List<Product> mockProductList(){
		List<Product> list = new ArrayList<Product>() ;
		
		Product p = new Product() ;
		p.setProduct("102812-BKS0");
		list.add(p) ;
		
		Product p1 = new Product() ;
		p1.setProduct("QBL10001-XGKG") ;
		list.add(p1) ;
		
		Product p2 = new Product() ;
		p2.setProduct("QBL10005-XKKW") ;
		list.add(p2) ;
		
		Product p3 = new Product() ;
		p3.setProduct("QY857364-KRR") ;
		list.add(p3) ;
		
		Product p4 = new Product() ;
		p4.setProduct("QY857410-XKBK") ;
		list.add(p4) ;
		
		Product p5 = new Product() ;
		p5.setProduct("QYL10006-XKSB") ;
		list.add(p5) ;
		
		Product p6 = new Product() ;
		p6.setProduct("QYL10028-XKBB") ;
		list.add(p6) ;
		
		Product p7 = new Product() ;
		p7.setProduct("AQMBS00036-BRD0") ;
		list.add(p7) ;
		
		Product p8 = new Product() ;
		p8.setProduct("AQMBS03010-KVJ0") ;
		list.add(p8) ;
		
		Product p9 = new Product() ;
		p9.setProduct("AQMFT03000-CRH0") ;
		list.add(p9) ;
		
		Product p10 = new Product() ;
		p10.setProduct("AQMFT03008-KVJ0") ;
		list.add(p10) ;
		
		return list ;
	}
}
