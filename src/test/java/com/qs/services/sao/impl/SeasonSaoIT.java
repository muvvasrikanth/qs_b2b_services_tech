package com.qs.services.sao.impl;

import static org.junit.Assert.*;

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
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qs.services.dao.ProductDao;
import com.qs.services.domain.BrandSeason;
import com.qs.services.domain.Product;
import com.qs.services.domain.SAPActiveSeasonProductList;
import com.qs.services.domain.SAPPrebookSeasonList;
import com.qs.services.domain.SalesRepBrandSeasons;
import com.qs.services.sao.SeasonSao;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SeasonSaoIT extends AbstractJUnit4SpringContextTests {

	private static final Logger logger = LoggerFactory.getLogger(SeasonSaoIT.class) ;
	
	private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF} ;
	private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]) ;
	
	@Autowired
	private SeasonSao sao ;
	
	@Autowired
	private ProductDao dao ;
	
	@Test
	public void testAutowiring() {
		assertNotNull(sao) ;
	}

	@Test
	public void testGetRepPrebkSeasons() throws JsonGenerationException, JsonMappingException, IOException{
		String salesRepId = "1002192" ;
		SAPPrebookSeasonList pbkSeasons = sao.getRepPrebkSeasons(salesRepId) ;
		assertNotNull(pbkSeasons) ;
		logger.info(new ObjectMapper().writeValueAsString(pbkSeasons));
		assertTrue(pbkSeasons.getPrebookSeasons().size() > 0) ;
	}
	
	@Test
	public void testGetSeasonProducts() throws JsonGenerationException, JsonMappingException, IOException{
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep("1002192");
		srbs.setSince("20140101:000000");
		BrandSeason bs = new BrandSeason() ;
		bs.setBrand("01");
		bs.setSeason("151");
		srbs.getBrandSeasons().add(bs) ;
		logger.info(new ObjectMapper().writeValueAsString(srbs));
		SAPActiveSeasonProductList actual = sao.getSeasonProducts(srbs) ;
		assertNotNull(actual) ;
		logger.info(new ObjectMapper().writeValueAsString(actual));
		assertTrue(actual.getProducts().size() > 0) ;
		assertTrue(actual.getProductSizes().size() > 0) ;
		assertTrue(actual.getProductPrices().size() > 0) ;
	}
	
	@Test
	public void testGetSeasonProductsNoReturn() throws JsonGenerationException, JsonMappingException, IOException {
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep("1002192");
		srbs.setSince("20140101:000000");
		BrandSeason bs = new BrandSeason() ;
		bs.setBrand("01");
		bs.setSeason("156");
		srbs.getBrandSeasons().add(bs) ;
		logger.info(new ObjectMapper().writeValueAsString(srbs));
		SAPActiveSeasonProductList actual = sao.getSeasonProducts(srbs) ;
		assertNotNull(actual) ;
		logger.info(new ObjectMapper().writeValueAsString(actual));
		assertTrue(actual.getEtReturn().size() > 0) ;
		assertEquals("Products not found for Active Seasons", actual.getEtReturn().get(0).getMessage()) ;
		assertEquals("004", actual.getEtReturn().get(0).getNumber()) ;
	}
	
	@Test
	public void testSalesRepBrandSeasonsToJson() throws JsonGenerationException, JsonMappingException, IOException{
		SalesRepBrandSeasons srbs = new SalesRepBrandSeasons() ;
		srbs.setSalesRep("1002192");
		srbs.setSince("20140101:000000");
		BrandSeason bs = new BrandSeason() ;
		bs.setBrand("01");
		bs.setSeason("151");
		srbs.getBrandSeasons().add(bs) ;
		logger.info(new ObjectMapper().writeValueAsString(srbs));
	}
	
	@Ignore
	@Test
	public void testGetImages() throws JsonGenerationException, JsonMappingException, IOException, InterruptedException{
		String salesRepId = "1002192" ;
		SAPPrebookSeasonList pbkSeasons = sao.getRepPrebkSeasons(salesRepId) ;
		assertNotNull(pbkSeasons) ;
		logger.info(new ObjectMapper().writeValueAsString(pbkSeasons)) ;
		
		SAPActiveSeasonProductList asProducts = sao.getActiveSeasonProducts(salesRepId, pbkSeasons) ;
		assertNotNull(asProducts) ;
		logger.info(new ObjectMapper().writeValueAsString(asProducts));
		
		List<Product> products = asProducts.getProducts() ;
		assertNotNull(products) ;
		
		Map <String, String> imageUrls = dao.getMediumHeroImageUrls(products) ;
		assertNotNull(imageUrls) ;
		
		DateFormat format = new SimpleDateFormat("yyyyMMdd@HH:mm:ss") ;
		Image image = null ;
		File file = null ;
		String v = null ;
		Date start = new Date() ;
		Date imgStart = null, imgEnd = null ;
		for(String k : imageUrls.keySet()){
			v = imageUrls.get(k) ;
			logger.info("ImageUrl (" + k + ") = " + k);
			imgStart = new Date() ;
			image = Toolkit.getDefaultToolkit().createImage(new URL(v)) ;
			file = new File("C:/temps/mbl_imgs/" + k + ".jpg") ;
			ImageIO.write(toBufferedImage(image), "jpg", file) ;
			imgEnd = new Date() ;
			logger.info("Loading image for (" + k + ") started=" + format.format(imgStart) + " : finished=" + format.format(imgEnd));
		}
		Date end = new Date() ;
		logger.info("Image load for (" + imageUrls.keySet().size() + ") images: started=" + format.format(start) + " : finished=" + format.format(end));
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
