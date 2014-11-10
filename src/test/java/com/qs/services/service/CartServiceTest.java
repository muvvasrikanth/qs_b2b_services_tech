package com.qs.services.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartList;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;
import com.qs.services.service.impl.CartServiceImpl;

@ContextConfiguration(locations={"/test-context.xml"})
@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest extends AbstractJUnit4SpringContextTests {

	@InjectMocks
	private CartService service = new CartServiceImpl() ;
	
	@Mock
	private CartDao dao ;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAutowiring(){
		assertNotNull(service) ;
	}
	
	@Test
	public void testInsertCart() throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		
		CartList cartList = mockCartList() ;
		when(dao.insertCartHeader(Mockito.any(Cart.class))).thenReturn(1) ;
		when(dao.insertCartProduct(Mockito.any(CartProduct.class), Mockito.any(Integer.class))).thenReturn(2) ;
		when(dao.insertCartProductSize(Mockito.any(CartProductSize.class))).thenReturn(3) ;
		when(dao.insertCartProductSizeRdd(Mockito.any(CartProductSizeRdd.class))).thenReturn(4) ;
		
		service.insertCarts(cartList);
		
		verify(dao).insertCartHeader(Mockito.any(Cart.class)) ;
		verify(dao).insertCartProduct(Mockito.any(CartProduct.class), Mockito.any(Integer.class)) ;
		verify(dao).insertCartProductSize(Mockito.any(CartProductSize.class)) ;
		verify(dao).insertCartProductSizeRdd(Mockito.any(CartProductSizeRdd.class)) ;
		
//        CartList cartList = new CartList();
//        Cart cart = new Cart();
//		cartList.getCarts().add(cart);
//        CartProduct cartProduct = new CartProduct();
//        cartProduct.setProductNumber("prod#1");
//        cart.getCartProducts().add(cartProduct);
//        CartProductSize cartProductSize = new CartProductSize();
//		cartProduct.getCartProductSizes().add(cartProductSize);
//		CartProductSizeRdd cartProductSizeRdd = new CartProductSizeRdd();
//		cartProductSize.getCartProductSizeRdds().add(cartProductSizeRdd);
//
//		List<Map<String,String>> cartProds = new ArrayList<Map<String,String>>();
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("id", "6");
//		map.put("product_number", "prod#1");
//		cartProds.add(map);
//		when((dao).insertCartHeader(cart)).thenReturn(1);
//		when((dao).insertCartProducts(cart.getCartProducts(), 1)).thenReturn(cartProds);
//		
//		List<Map<String,String>> cartProdSizes = new ArrayList<Map<String,String>>();
//		Map<String,String> map2 = new HashMap<String,String>();
//		map2.put("id", "103");
//		map2.put("salesdoc_product_id", "6");
//		cartProdSizes.add(map2);
//		when((dao).insertCartProductSizes(cartProduct.getCartProductSizes())).thenReturn(cartProdSizes);
//		
//		service.insertCarts(cartList);
//		
//		assertEquals(new Integer(6), cartProductSize.getSalesDocProductId());
//		assertEquals(new Integer(103), cartProductSizeRdd.getProductSizeId());
//		
//		verify(dao).insertCartHeader(cart);
//		verify(dao).insertCartProducts(cart.getCartProducts(), 1);
//		verify(dao).insertCartProductSizes(cartProduct.getCartProductSizes());
//		verify(dao).insertCartProductSizeRdds(cartProductSize.getCartProductSizeRdds());
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
