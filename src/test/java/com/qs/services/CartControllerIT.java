package com.qs.services;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qs.services.domain.Cart;
import com.qs.services.domain.CartList;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;
import com.qs.services.util.StringUtil;

@ContextConfiguration(locations={"classpath:/META-INF/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CartControllerIT extends AbstractJUnit4SpringContextTests {

	private static final Logger logger = LoggerFactory.getLogger(CartControllerIT.class) ;
	
	@Autowired
	private CartController controller ;
	
	@Test
	public void testAutowiring() {
		assertNotNull(controller) ;
	}

	@Test
	public void testInsertCart() throws ParseException, JsonGenerationException, JsonMappingException, IOException{
		CartList cartList = mockCartList() ;
		logger.info(new ObjectMapper().writeValueAsString(cartList));
	}
	
	@Test
	public void testInsertAccentedCart() throws ParseException, JsonGenerationException, JsonMappingException, IOException{
		CartList cartList = mockCartListAccented() ;
		logger.info(new ObjectMapper().writeValueAsString(cartList));
		String json = StringUtil.normalize(new ObjectMapper().writeValueAsString(cartList)) ;
		logger.info(json);
	}
	
	private CartList mockCartList() throws ParseException{
		DateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
		String sdn = "IT " + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) ;
		CartList cl = new CartList() ;
		Cart c = new Cart() ;
		c.setDocCatagoryId(3);
		c.setMethodCodeId(1);
		c.setCustomerNumber("1034651");
		c.setShipToNumber("1034651");
		c.setSalesDocName(sdn);
		c.setCustomerPoNumber(sdn);
		c.setRequestedDeliveryDt("20150101");
		c.setCancelDt("20150131");
		c.setReadyForSubmissionValue("N");
		c.setDraftSalesDocStatusId(8);
		c.setExternalStatus("TEST_ES");
		c.setShared("N");
		c.setReferenceDocumentNumber("TEST_RDN");
		c.setiDocNumber("TEST_IDN");
		c.setLatestIDocNumber("TEST_LIDN");
		c.setSapOrderNumber("TEST_SON");
		c.setCreatedBy(getClass().getSimpleName());
		c.setCreatedOn(dbDateFormat.format(new Date()));
		c.setLastUpdateBy(getClass().getSimpleName());
		c.setLastUpdateOn(dbDateFormat.format(new Date()));
		c.setNotes("TEST_NOTES") ;
		c.setValidFrom("20150101");
		c.setValidTo("20150201");
		c.setShippingInstructions("TEST_SI");
		c.setCarrierName("TEST_CN");
		c.setCarrierAcno("TEST_CACNO");
		c.setExcelPath("TEST_EP");
		c.setExcelFileName("TEST_EFN");
		c.setDocTypeId("ZSO");
		c.setOrderContext("PREBOOK");
		c.setSeason("151");
		c.setReason("002");
		c.setUnits(0);
		c.setTotalQuantities(0);
		c.setTotalBasePrice(0.00);
		c.setTotalMsrpPrice(0.00);
		c.setTotalMapPrice(0.00);
		c.setDeltaFlag(Boolean.FALSE);
		c.setSubmittedCartId("TEST_SCID");
		
		CartProduct cp0 = new CartProduct() ;
		cp0.setProductNumber("ADYJK03014-KVJ0");
		cp0.setGenderFit("TEST_GF");
		cp0.setStyle("TEST_STYLE");
		cp0.setCreatedBy(getClass().getSimpleName());
		cp0.setCreatedDateTime(dbDateFormat.format(new Date()));
		cp0.setModifiedBy(getClass().getSimpleName());
		cp0.setModifiedDateTime(dbDateFormat.format(new Date()));
		cp0.setDimension("TEST_DIMENSION");
		cp0.setRequestedDeliveryDate("20150115");
		cp0.setUnitOfMeasure("EA");
		cp0.setLineItemNo("TEST_LIN");
		cp0.setDlvGroup("TEST_DLV_GROUP");
		cp0.setAutoAllocation(Boolean.TRUE);
		cp0.setBrand("01");
		cp0.setSalesOrg("3000");
		cp0.setDistrubutionChannel("10");
		cp0.setSeason("151");
		cp0.setSequence(99.00);
		cp0.setBasePrice(0.00);
		cp0.setMsrpPrice(0.00);
		cp0.setMapPrice(0.00);
		cp0.setNetPrice(0.00);
		cp0.setDiscount(0.00);
		cp0.setDiscountPercent(0.00);
		cp0.setQuantities(0);
		cp0.setTotalBasePrice(0.00);
		cp0.setTotalMsrpPrice(0.00);
		cp0.setTotalMapPrice(0.00);
		cp0.setTotalNetPrice(0.00);
		
		CartProductSize cps0 = new CartProductSize() ;
		cps0.setSize("10 D");
		cps0.setQuantity(1);
		cps0.setCreatedBy(getClass().getSimpleName());
		cps0.setCreatedDateTime(dbDateFormat.format(new Date()));
		cps0.setModifiedBy(getClass().getSimpleName());
		cps0.setModifiedDateTime(dbDateFormat.format(new Date()));
		
		CartProductSizeRdd cpsr0 = new CartProductSizeRdd();
		cpsr0.setRequestedDeliveryDate("20150115");
		cpsr0.setOriginalRequestedDeliveryDate("20150110");
		cpsr0.setQuantity(1);
				
		//TODO Add products, sizes and rdds

		cps0.getCartProductSizeRdds().add(cpsr0) ;
		cp0.getCartProductSizes().add(cps0) ;
		c.getCartProducts().add(cp0) ;
		cl.getCarts().add(c) ;
		return cl ;
	}

	private CartList mockCartListAccented() throws ParseException{
		DateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
		String sdn = "accessoires rentrée des classes " + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) ;
		CartList cl = new CartList() ;
		Cart c = new Cart() ;
		c.setDocCatagoryId(3);
		c.setMethodCodeId(1);
		c.setCustomerNumber("1034651");
		c.setShipToNumber("1034651");
		c.setSalesDocName(sdn);
		c.setCustomerPoNumber(sdn);
		c.setRequestedDeliveryDt("20150101");
		c.setCancelDt("20150131");
		c.setReadyForSubmissionValue("N");
		c.setDraftSalesDocStatusId(8);
		c.setExternalStatus("TEST_ES");
		c.setShared("N");
		c.setReferenceDocumentNumber("TEST_RDN");
		c.setiDocNumber("TEST_IDN");
		c.setLatestIDocNumber("TEST_LIDN");
		c.setSapOrderNumber("TEST_SON");
		c.setCreatedBy(getClass().getSimpleName());
		c.setCreatedOn(dbDateFormat.format(new Date()));
		c.setLastUpdateBy(getClass().getSimpleName());
		c.setLastUpdateOn(dbDateFormat.format(new Date()));
		c.setNotes("TEST_NOTES") ;
		c.setValidFrom("20150101");
		c.setValidTo("20150201");
		c.setShippingInstructions("TEST_SI");
		c.setCarrierName("TEST_CN");
		c.setCarrierAcno("TEST_CACNO");
		c.setExcelPath("TEST_EP");
		c.setExcelFileName("TEST_EFN");
		c.setDocTypeId("ZSO");
		c.setOrderContext("PREBOOK");
		c.setSeason("151");
		c.setReason("002");
		c.setUnits(0);
		c.setTotalQuantities(0);
		c.setTotalBasePrice(0.00);
		c.setTotalMsrpPrice(0.00);
		c.setTotalMapPrice(0.00);
		c.setDeltaFlag(Boolean.FALSE);
		c.setSubmittedCartId("TEST_SCID");
		
		CartProduct cp0 = new CartProduct() ;
		cp0.setProductNumber("ADYJK03014-KVJ0");
		cp0.setGenderFit("TEST_GF");
		cp0.setStyle("TEST_STYLE");
		cp0.setCreatedBy(getClass().getSimpleName());
		cp0.setCreatedDateTime(dbDateFormat.format(new Date()));
		cp0.setModifiedBy(getClass().getSimpleName());
		cp0.setModifiedDateTime(dbDateFormat.format(new Date()));
		cp0.setDimension("TEST_DIMENSION");
		cp0.setRequestedDeliveryDate("20150115");
		cp0.setUnitOfMeasure("EA");
		cp0.setLineItemNo("TEST_LIN");
		cp0.setDlvGroup("TEST_DLV_GROUP");
		cp0.setAutoAllocation(Boolean.TRUE);
		cp0.setBrand("01");
		cp0.setSalesOrg("3000");
		cp0.setDistrubutionChannel("10");
		cp0.setSeason("151");
		cp0.setSequence(99.00);
		cp0.setBasePrice(0.00);
		cp0.setMsrpPrice(0.00);
		cp0.setMapPrice(0.00);
		cp0.setNetPrice(0.00);
		cp0.setDiscount(0.00);
		cp0.setDiscountPercent(0.00);
		cp0.setQuantities(0);
		cp0.setTotalBasePrice(0.00);
		cp0.setTotalMsrpPrice(0.00);
		cp0.setTotalMapPrice(0.00);
		cp0.setTotalNetPrice(0.00);
		
		CartProductSize cps0 = new CartProductSize() ;
		cps0.setSize("10 D");
		cps0.setQuantity(1);
		cps0.setCreatedBy(getClass().getSimpleName());
		cps0.setCreatedDateTime(dbDateFormat.format(new Date()));
		cps0.setModifiedBy(getClass().getSimpleName());
		cps0.setModifiedDateTime(dbDateFormat.format(new Date()));
		
		CartProductSizeRdd cpsr0 = new CartProductSizeRdd();
		cpsr0.setRequestedDeliveryDate("20150115");
		cpsr0.setOriginalRequestedDeliveryDate("20150110");
		cpsr0.setQuantity(1);
				
		//TODO Add products, sizes and rdds

		cps0.getCartProductSizeRdds().add(cpsr0) ;
		cp0.getCartProductSizes().add(cps0) ;
		c.getCartProducts().add(cp0) ;
		cl.getCarts().add(c) ;
		return cl ;
	}
}
