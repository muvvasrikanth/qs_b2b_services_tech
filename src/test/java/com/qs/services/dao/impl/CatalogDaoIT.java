package com.qs.services.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesArea;
import com.qs.services.domain.SalesAreaList;
import com.qs.services.util.Config;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogDaoIT extends AbstractJUnit4SpringContextTests {
	
	private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF} ;
	private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]) ;
	
	@Autowired
	private CatalogDao dao ;
	
	@Autowired
	private Config config ;

	@Test
	public void testAutowiring() {
		assertNotNull(dao) ;
	}

	@Test
	public void testGetCatalogs() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList list = dao.getCatalogs("01", "1000", "10") ;
		assertNotNull(list) ;
		assertTrue(list.getCatalogs().size() > 0) ;
		logger.info("There are (" + list.getCatalogs().size() + ") catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(list)) ;
	}
	
	@Test
	public void testGetCatalogsForSalesAreas() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList actual = dao.getCatalogs(mockSalesAreaList()) ;
		assertNotNull(actual) ;
		assertTrue(actual.getCatalogs().size() > 0) ;
		logger.info("There are (" + actual.getCatalogs().size() + " ) catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(actual));
	}
	
	@Test
	public void testGetCatalogsForSalesAreasEricGraciet() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList actual = dao.getCatalogs(mockEricGracietSalesAreaList()) ;
		assertNotNull(actual) ;
		assertTrue(actual.getCatalogs().size() > 0) ;
		logger.info("There are (" + actual.getCatalogs().size() + " ) catalogs in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(actual));
	}
	
	@Test 
	public void testGetEmptyCatalogs() throws JsonGenerationException, JsonMappingException, IOException{
		CatalogList actual = new CatalogList() ;
		String actualJson = new ObjectMapper().writeValueAsString(actual) ;
		assertNotNull(actualJson) ;
		assertEquals("{\"catalogs\":[]}", actualJson) ;
		logger.info(actualJson) ;
	}
	
	@Test
	public void testGetCatalogCriteria() throws JsonGenerationException, JsonMappingException, IOException{
		Integer catalogId = 74 ;
		CatalogSearchCriteriaList criteriaList = dao.getCatalogSearchCriterias(catalogId) ;
		assertNotNull(criteriaList) ;
		assertTrue(criteriaList.getCatalogSearchCriterias().size() > 0) ;
		logger.info("There are (" + criteriaList.getCatalogSearchCriterias().size() + ") catalog search criteria in the list");
		ObjectMapper mapper = new ObjectMapper() ;
		logger.info(mapper.writeValueAsString(criteriaList));
	}
	
//	@Test
//	public void testGetCatalogCoverImage() throws InterruptedException, IOException {
//		AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials("AKIAIE7QAD2RU3NFTZMQ", "2bFh0jVhvGqt87YX+6euHbDyPnp4nFX62sfsIpfu")) ;
//		String filename = "RX APPAREL.png" ;
//		GeneratePresignedUrlRequest gpur = new GeneratePresignedUrlRequest(config.getS3BucketName(), filename) ;
//		gpur.setMethod(HttpMethod.GET) ;
//		Calendar c = Calendar.getInstance() ;
//		c.add(Calendar.MONTH, 1);
//		gpur.setExpiration(c.getTime());
//		URL url = s3Client.generatePresignedUrl(gpur) ;
//		logger.info(url.toExternalForm());
//		Image image = Toolkit.getDefaultToolkit().createImage(url) ;
//		BufferedImage buffered = toBufferedImage(image) ;
//		File file = new File("C:/temps/RX_APPAREL.png") ;
//		ImageIO.write(buffered, "png", file) ;
//	}
	
	@Test
	public void testGetChildren(){
		Integer catalogId = 233 ;
		List<Integer> actual = new ArrayList<Integer>() ;
		actual.add(catalogId) ;
		List<Integer> expected = new ArrayList<Integer>() ;
		expected.add(233) ;
		expected.add(234) ;
		expected.add(235) ;
		expected.add(236) ;
		expected.add(280) ;
		
		actual = dao.getChildren(actual, catalogId) ;
		
		logger.info(actual);
		
		assertNotNull(actual) ;
		assertEquals(expected.size(), actual.size()) ;
		assertTrue(actual.contains(233)) ;
		assertTrue(actual.contains(234)) ;
		assertTrue(actual.contains(235)) ;
		assertTrue(actual.contains(236)) ;
		assertTrue(actual.contains(280)) ;
	}
	
	private SalesAreaList mockEricGracietSalesAreaList(){
		SalesAreaList list = new SalesAreaList() ;
		
		SalesArea sa0 = new SalesArea() ;
		sa0.setBrand("02");
		sa0.setSalesOrg("2000");
		sa0.setDistributionChannel("10");
		list.getSalesAreas().add(sa0) ;
		
		SalesArea sa1 = new SalesArea() ;
		sa1.setBrand("03");
		sa1.setSalesOrg("2000");
		sa1.setDistributionChannel("10");
		list.getSalesAreas().add(sa1) ;
		
		SalesArea sa2 = new SalesArea() ;
		sa2.setBrand("02");
		sa2.setSalesOrg("2140");
		sa2.setDistributionChannel("10");
		list.getSalesAreas().add(sa2) ;
		
		return list ;
	}
	
	private SalesAreaList mockSalesAreaList(){
		SalesAreaList list = new SalesAreaList() ;
		
		SalesArea sa0 = new SalesArea() ;
		sa0.setBrand("01");
		sa0.setSalesOrg("1000");
		sa0.setDistributionChannel("10");
		list.getSalesAreas().add(sa0) ;
		
		SalesArea sa1 = new SalesArea() ;
		sa1.setBrand("02");
		sa1.setSalesOrg("1030");
		sa1.setDistributionChannel("10");
		list.getSalesAreas().add(sa1) ;
		
		SalesArea sa2 = new SalesArea() ;
		sa2.setBrand("03");
		sa2.setSalesOrg("1030");
		sa2.setDistributionChannel("10");
		list.getSalesAreas().add(sa2) ;
		
		SalesArea sa3 = new SalesArea() ;
		sa3.setBrand("01");
		sa3.setSalesOrg("1050");
		sa3.setDistributionChannel("10");
		list.getSalesAreas().add(sa3) ;
		
		SalesArea sa4 = new SalesArea() ;
		sa4.setBrand("02");
		sa4.setSalesOrg("1050");
		sa4.setDistributionChannel("10");
		list.getSalesAreas().add(sa4) ;

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
