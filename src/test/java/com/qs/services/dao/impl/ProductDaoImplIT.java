package com.qs.services.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.dao.ProductDao;
import com.qs.services.domain.Product;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoImplIT extends AbstractJUnit4SpringContextTests {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImplIT.class) ;
	
	private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF} ;
	private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]) ;

	private static final int TARGET_WIDTH = 2000 ;

	private static final int TARGET_HEIGHT = 2666 ;


	@Autowired
	private ProductDao dao ;
	
	@Test
	public void testAutowiring() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGetHeroImage() throws InterruptedException, IOException{
		Map<String, String> imageUrls = dao.getMediumHeroImageUrls(mockProductList()) ;
		assertNotNull(imageUrls) ;
		String urlString ;
		URL url ;
		Image image ;
		BufferedImage bufferedImage ;
		String path = "C:/temps/mbl_imgs/" ;
		File file ;
		
		for(String key : imageUrls.keySet()){
			urlString = imageUrls.get(key) ;
			logger.info("Getting: " + urlString);
			url = new URL(urlString) ;
			image = Toolkit.getDefaultToolkit().createImage(url) ;
			bufferedImage = toBufferedImage(image) ;
			file = new File(path + key + ".jpg") ;
			logger.info("Writing: " + file.getAbsolutePath());
			ImageIO.write(bufferedImage, "JPG", file) ;
		}
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
	
	private BufferedImage toBufferedImage(Image image) throws InterruptedException{
		if(image instanceof BufferedImage){
			return (BufferedImage) image ;
		} 
		
		PixelGrabber grabber = new PixelGrabber(image, 0, 0, -1, -1, true) ;
		grabber.grabPixels() ;
		
		DataBuffer buffer = new DataBufferInt((int[]) grabber.getPixels(), grabber.getWidth() * grabber.getHeight()) ;
		WritableRaster raster = Raster.createPackedRaster(buffer, grabber.getWidth(), grabber.getHeight(), grabber.getWidth(), RGB_MASKS, null) ;
		return new BufferedImage(RGB_OPAQUE, raster, false, null) ;
	}

}
