package com.qs.services.domain;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CartListInputTest {
    
	private static final Logger logger = LoggerFactory.getLogger(CartListInputTest.class) ;
	
    @Test
    public void testCartList() throws Exception{
        
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/data/cart.txt");
        String json = IOUtils.toString(resourceAsStream);
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        CartList cartList = new CartList();
        Cart cart = new Cart();
		cartList.getCarts().add(cart);
        CartProduct cartProduct = new CartProduct();
        cart.getCartProducts().add(cartProduct);
        CartProductSize cartProductSize = new CartProductSize();
		cartProduct.getCartProductSizes().add(cartProductSize);
		cartProductSize.getCartProductSizeRdds().add(new CartProductSizeRdd());
		String result = ow.writeValueAsString(cartList);
        logger.info("\n\n" + result + "\n\n");
        assertEquals(json, result);
    }
    
    @Test
    public void testCartListToJson() throws ParseException, JsonProcessingException {
    	CartList cartList = mockCartList() ;
    	ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter() ;
    	String result = writer.writeValueAsString(cartList) ;
    	logger.info("\n\n" + result + "\n\n");
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
		c.setRequestedDeliveryDt(dbDateFormat.parse("2015-01-01"));
		c.setCancelDt(dbDateFormat.parse("2015-01-31"));
		c.setReadyForSubmissionValue("N");
		c.setDraftSalesDocStatusId(8);
		c.setExternalStatus("TEST_ES");
		c.setShared("N");
		c.setReferenceDocumentNumber("TEST_RDN");
		c.setiDocNumber("TEST_IDN");
		c.setLatestIDocNumber("TEST_LIDN");
		c.setSapOrderNumber("TEST_SON");
		c.setCreatedBy(getClass().getSimpleName());
		c.setCreatedOn(new Date());
		c.setLastUpdateBy(getClass().getSimpleName());
		c.setLastUpdateOn(new Date());
		c.setNotes("TEST_NOTES") ;
		c.setValidFrom(dbDateFormat.parse("2015-01-01"));
		c.setValidTo(dbDateFormat.parse("2015-02-01"));
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
		cp0.setCreatedDateTime(new Date());
		cp0.setModifiedBy(getClass().getSimpleName());
		cp0.setModifiedDateTime(new Date());
		cp0.setDimenison("TEST_DIMENSION");
		cp0.setRequestedDeliveryDate(dbDateFormat.parse("2015-01-15"));
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
		cps0.setCreatedDateTime(new Date());
		cps0.setModifiedBy(getClass().getSimpleName());
		cps0.setModifiedDateTime(new Date());
		
		CartProductSizeRdd cpsr0 = new CartProductSizeRdd();
		cpsr0.setRequestedDeliveryDate(dbDateFormat.parse("2015-01-15"));
		cpsr0.setOriginalRequestedDeliveryDate(dbDateFormat.parse("2015-01-10"));
		cpsr0.setQuantity(1);
				
		//TODO Add products, sizes and rdds

		cps0.getCartProductSizeRdds().add(cpsr0) ;
		cp0.getCartProductSizes().add(cps0) ;
		c.getCartProducts().add(cp0) ;
		cl.getCarts().add(c) ;
		return cl ;
	}

}
