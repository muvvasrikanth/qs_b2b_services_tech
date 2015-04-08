package com.qs.services.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.qs.services.dao.CartDao;
import com.qs.services.domain.Cart;
import com.qs.services.domain.CartProduct;
import com.qs.services.domain.CartProductSize;
import com.qs.services.domain.CartProductSizeRdd;
import com.qs.services.domain.SAPCustomer;
import com.qs.services.sao.CustomerSao;
import com.qs.services.util.StringUtil;

@Component
public class CartDaoImpl implements CartDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class); 
	
	private static final ObjectMapper mapper = new ObjectMapper() ;
	
	@Autowired
	private CustomerSao customerSao ;

	@Autowired
	private JdbcTemplate template ;
	
	@SuppressWarnings("deprecation")
	@Override
	public Integer insertCartHeader(Cart cart){
		Integer retVal = null ;
		logger.warn("Cart.draftSalesDocGuid="+ cart.getDraftSalesDocGuid());
		try{
			String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_HEADER] ([DOC_CATEGORY_ID],[METHOD_CODE_ID],[CUSTOMER_NUMBER],[SHIP_TO_NUMBER],[SALES_DOC_NAME],[CUSTOMER_PO_NUMBER],[REQUESTED_DELIVERY_DT],[CANCEL_DT],[READYFORSUBMISSION_VALUE],[DRAFTSALESDOC_STATUS_ID],[EXTENAL_STATUS],[INTERNAL_STATUS],[SHARED],[REFERENCE_DOCUMENT_NUMBER],[IDOC_NUMBER],[LATEST_IDOC_NUMBER],[SAP_ORDER_NUMBER],[CREATED_BY],[CREATED_ON],[LAST_UPDATE_BY],[LAST_UPDATE_ON],[NOTES],[VALID_FROM],[VALID_TO],[SHIPPING_INSTRUCTION],[CARRIER_NAME],[CARRIER_ACNO],[EXCEL_PATH],[EXCEL_FILE_NAME],[DOC_TYPE_ID],[ORDER_CONTEXT],[SEASON],[REASON],[UNITS],[TOTAL_QUANTITIES],[TOTAL_BASE_PRICE],[TOTAL_MSRP_PRICE],[TOTAL_MAP_PRICE],[TOTAL_NET_PRICE],[DELTA_FLAG],[SUBMITTED_CART_ID], [CUSTOMER_NAME], [DRAFT_SALESDOC_GUID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)" ;
			Object[] parms = {
//				cart.getDocCatagoryId(),
				(cart.getDocTypeId().equalsIgnoreCase("ZCQ") ? 2 : 3),
//				cart.getMethodCodeId(), Temporarily hard coding the method to be 5 - Excel because of issues in QC
				(cart.getDocTypeId().equalsIgnoreCase("ZCQ") ? 28 : 27),
				cart.getCustomerNumber(),
				cart.getShipToNumber(),
				cart.getSalesDocName(),
				cart.getCustomerPoNumber(),
				fromYYYYMMDDtoDate(cart.getRequestedDeliveryDt()),
				fromYYYYMMDDtoDate(cart.getCancelDt()),
				cart.getReadyForSubmissionValue(),
				cart.getDraftSalesDocStatusId(),
				cart.getExternalStatus(),
				cart.getInternalStatus(),
				cart.getShared(),
				cart.getReferenceDocumentNumber(),
				cart.getiDocNumber(),
				cart.getLatestIDocNumber(),
				cart.getSapOrderNumber(),
				cart.getCreatedBy(),
				fromYYYYMMDDtoDate(cart.getCreatedOn()),
				cart.getLastUpdateBy(),
				fromYYYYMMDDtoDate(cart.getLastUpdateOn()),
				cart.getNotes(),
				fromYYYYMMDDtoDate(cart.getValidFrom()),
				fromYYYYMMDDtoDate(cart.getValidTo()),
				cart.getShippingInstructions(),
				cart.getCarrierName(),
				cart.getCarrierAcno(),
				cart.getExcelPath(),
				cart.getExcelFileName(),
				cart.getDocTypeId(),
				cart.getOrderContext(),
				cart.getSeason(),
				cart.getReason(),
				cart.getUnits(),
				cart.getTotalQuantities(),
				cart.getTotalBasePrice(),
				cart.getTotalMsrpPrice(),
				cart.getTotalMapPrice(),
				cart.getTotalNetPrice(),
				cart.getDeltaFlag(),
				cart.getSubmittedCartId(),
				(cart.getCustomerName() != null ? cart.getCustomerName() : getCustomerName(cart.getCustomerNumber())),
				cart.getDraftSalesDocGuid()
			} ;
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql0);}
			template.update(sql0, parms) ;
			
			String sql1 = "SELECT MAX(draft_salesdoc_header_id) FROM [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_HEADER] WHERE CREATED_BY = ? AND CUSTOMER_NUMBER = ? AND SALES_DOC_NAME = ? AND DRAFT_SALESDOC_GUID = ?" ;
			Object[] parms2 = {
				cart.getCreatedBy(),
				cart.getCustomerNumber(),
				cart.getSalesDocName(),
				cart.getDraftSalesDocGuid()
			} ;
			
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql1 + " :: [CREATED_BY='" + cart.getCreatedBy() + "', CUSTOMER_NUMBER=" + cart.getCustomerNumber() + ", SALES_DOC_NAME='" + cart.getSalesDocName() + "', GUID='" + cart.getDraftSalesDocGuid() + "'");}
			retVal = template.queryForInt(sql1, parms2) ;
		} catch (ParseException e){
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e) ;
		}
		
		return retVal ;
	}
	
	private String getCustomerName(String customerNumber) throws JsonGenerationException, JsonMappingException, IOException{
		String customerName = null ;
		if(logger.isDebugEnabled()){logger.debug("Getting SAP Customer Details for (" + customerNumber + ")") ;}
		SAPCustomer sapCustomer = customerSao.getCustomerDetails(customerNumber) ;
		if(logger.isDebugEnabled()){logger.debug(mapper.writeValueAsString(sapCustomer)) ;}
		if(sapCustomer != null){
			customerName = sapCustomer.getSoldToName() ;
		}
		return customerName ;
	}
	
	private String generateGuid(){
		String uuidString = UUID.randomUUID().toString() ;
		if(logger.isDebugEnabled()){logger.debug("Generating UUID: " + uuidString);}
		return uuidString ;
	}

	@Override
	public Integer insertCartProduct(CartProduct product,
			Integer cartId) throws JsonGenerationException,
			JsonMappingException, IOException {
		Integer retVal = null ;
		if(logger.isDebugEnabled()){logger.debug("Cart Product: " + mapper.writeValueAsString(product));}
		try{
			String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_MAPPING]([DRAFT_SALESDOC_HEADER_ID],[PRODUCT_NUMBER],[GENDER_FIT],[STYLE],[CREATEDBY],[CREATEDDATETIME],[MODIFIEDBY],[MODIFIEDDATETIME],[DIMENSION],[RDD],[UOM],[LINE_ITEM_NO],[DLV_GROUP],[AUTOALLOCATION],[BRAND],[SALES_ORG],[DISTRIBUTION_CHANNEL],[SEASON],[SEQUENCE],[BASE_PRICE],[MSRP_PRICE],[MAP_PRICE],[NET_PRICE],[DISCOUNT],[DISCOUNT_PERCENT],[QUANTITIES],[TOTAL_BASE_PRICE],[TOTAL_MSRP_PRICE],[TOTAL_MAP_PRICE],[TOTAL_NET_PRICE])VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
			Object[] parms = {
					cartId,
					product.getProductNumber(),
					product.getGenderFit(),
					product.getStyle(),
					product.getCreatedBy(),
					fromYYYYMMDDtoDate(product.getCreatedDateTime()),
					product.getModifiedBy(),
					fromYYYYMMDDtoDate(product.getModifiedDateTime()),
					product.getDimension(),
					fromYYYYMMDDtoDate(product.getRequestedDeliveryDate()),
					product.getUnitOfMeasure(),
					product.getLineItemNo(),
					product.getDlvGroup(),
					product.getAutoAllocation(),
					product.getBrand(),
					product.getSalesOrg(),
					product.getDistrubutionChannel(),
					product.getSeason(),
					product.getSequence(),
					product.getBasePrice(),
					product.getMsrpPrice(),
					product.getMapPrice(),
					product.getNetPrice(),
					product.getDiscount(),
					product.getDiscountPercent(),
					product.getQuantities(),
					product.getTotalBasePrice(),
					product.getTotalMsrpPrice(),
					product.getTotalMapPrice(),
					product.getTotalNetPrice()
				} ;
				
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql0 + "][Values (" + toParameter(parms) + ")]") ;}
				
			template.update(sql0, parms) ;
	
			String sql1 = "SELECT id FROM [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_MAPPING] WHERE [DRAFT_SALESDOC_HEADER_ID] = " + cartId + " AND [PRODUCT_NUMBER] = '" + product.getProductNumber() + "'" ;
			
			if(logger.isDebugEnabled()){logger.debug(sql1) ;}
			
			retVal = template.queryForInt(sql1) ;
		} catch (ParseException e){
			logger.error(e.getMessage(), e);
		}
		
		return retVal ;
	}

	@Override
	public Integer insertCartProductSize(
			CartProductSize cartProductSize) {
		Integer retVal = null ;
		
		try{
			String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_MAPPING]([SALESDOC_PRODUCT_ID],[SIZE],[QUANTITY],[DIMENSION],[CREATEDBY],[CREATEDDATETIME],[MODIFIEDBY],[MODIFIEDDATETIME])VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
			
			Object[] parms = {
				cartProductSize.getSalesDocProductId(),
				cartProductSize.getSize(),
				cartProductSize.getQuantity(),
				cartProductSize.getDimension(),
				cartProductSize.getCreatedBy(),
				fromYYYYMMDDtoDate(cartProductSize.getCreatedDateTime()),
				cartProductSize.getModifiedBy(),
				fromYYYYMMDDtoDate(cartProductSize.getModifiedDateTime())
			} ;
	
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql0 + "][Values (" + toParameter(parms) + ")]");}
			
			template.update(sql0, parms) ;
			
			String sql1 = "SELECT id FROM [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_MAPPING] WHERE [SALESDOC_PRODUCT_ID] = " + cartProductSize.getSalesDocProductId() + " AND [SIZE] = '" + cartProductSize.getSize() + "'" ;
			
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql1);}
			
			retVal =  template.queryForInt(sql1) ;
		} catch (ParseException e){
			logger.error(e.getMessage(), e) ;
		}
		
		return retVal ;
	}

	@Override
	public Integer insertCartProductSizeRdd(
			CartProductSizeRdd cartProductSizeRdd) {
		
		Integer retVal = null ;
		try{
			String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_RDD_MAPPING]([PRODUCT_SIZE_ID],[QUANTITY],[RDD],[ORIGINAL_RDD]) VALUES (?, ?, ?, ?)" ;
			
			Object[] parms = {
				cartProductSizeRdd.getProductSizeId(),
				cartProductSizeRdd.getQuantity(),
				fromYYYYMMDDtoDate(cartProductSizeRdd.getRequestedDeliveryDate()),
				fromYYYYMMDDtoDate(cartProductSizeRdd.getOriginalRequestedDeliveryDate())
			};
			
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql0 + "][Values (" + toParameter(parms) + ")]");}
			
			template.update(sql0, parms) ;
			
			String sql1 = "SELECT id FROM [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_RDD_MAPPING] WHERE [PRODUCT_SIZE_ID] = " + cartProductSizeRdd.getProductSizeId() + " AND [RDD] = '" + new SimpleDateFormat("yyyy-MM-dd").format(fromYYYYMMDDtoDate(cartProductSizeRdd.getRequestedDeliveryDate())) + "'" ;
			
			if(logger.isDebugEnabled()){logger.debug("Executing : " + sql1);}
			
			retVal = template.queryForInt(sql1);
		} catch (ParseException e){
			logger.error(e.getMessage(), e) ;
		}
		
		return retVal ;
	}
	
	private String toParameter(Object[] parms) {
		StringBuilder b = new StringBuilder() ;
		int index = 0 ;
		for(Object o : parms){
			if(o != null){
				if(o instanceof String){
					b.append("'") ;
					b.append(o) ;
					b.append("'") ;
				} else if(o instanceof Integer || o instanceof Double){
					b.append(o) ;
				} else if(o instanceof Date){
					b.append("'") ;
					b.append(new SimpleDateFormat("yyyy-MM-dd").format((Date) o)) ;
					b.append("'") ;
				} else if (o instanceof Boolean){
					b.append((Boolean)o ? "1" : "0") ;
				} else {
					logger.warn("Object type of (" + o + ") was " + o.getClass().getSimpleName());
				}
			} else {
				b.append("null") ;
			}
			
			b.append(index++ <= parms.length-1 ? "," : "") ;
		}
		return b.toString() ;
	}
	
	private Date fromYYYYMMDDtoDate(String strDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyyMMdd") ;
		Date retDate = null ;
		if(null != strDate){
			retDate = df.parse(strDate) ;
		}
		
		return retDate ;
	}
}

/**
 * A generic implementation of row mapper to return results that do not merit
 * having their own row mapper but can't be addressed with a single return.
 * @author jtryon
 *
 */
class GenericRowMapper implements RowMapper <Map<String, String>> {

	private static final Logger logger = LoggerFactory.getLogger(GenericRowMapper.class) ;
	
	@Override
	public Map<String, String> mapRow(ResultSet rs, int row)
			throws SQLException {
		Map<String, String> m = new HashMap<String, String>() ;
		String key=null, value=null ;
		if(logger.isDebugEnabled()){logger.debug("Mapping result set values");}
		for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
			key = rs.getMetaData().getColumnName(i) ;
			value = rs.getString(i) ;
			if(logger.isDebugEnabled()){logger.debug("Storing {" + key + ", " + value + "}") ;}
			m.put(key, value) ;
		}
		logger.debug("Returning " + m) ;
		return m ;
	}
	
}
