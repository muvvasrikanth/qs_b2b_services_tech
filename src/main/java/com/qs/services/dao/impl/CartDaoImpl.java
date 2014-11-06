package com.qs.services.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Component
public class CartDaoImpl implements CartDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class); 

	@Autowired
	private JdbcTemplate template ;
	
	@Override
	public Integer insertCartHeader(Cart cart){
		String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_HEADER] ([DOC_CATEGORY_ID],[METHOD_CODE_ID],[CUSTOMER_NUMBER],[SHIP_TO_NUMBER],[SALES_DOC_NAME],[CUSTOMER_PO_NUMBER],[REQUESTED_DELIVERY_DT],[CANCEL_DT],[READYFORSUBMISSION_VALUE],[DRAFTSALESDOC_STATUS_ID],[EXTENAL_STATUS],[INTERNAL_STATUS],[SHARED],[REFERENCE_DOCUMENT_NUMBER],[IDOC_NUMBER],[LATEST_IDOC_NUMBER],[SAP_ORDER_NUMBER],[CREATED_BY],[CREATED_ON],[LAST_UPDATE_BY],[LAST_UPDATE_ON],[NOTES],[VALID_FROM],[VALID_TO],[SHIPPING_INSTRUCTION],[CARRIER_NAME],[CARRIER_ACNO],[EXCEL_PATH],[EXCEL_FILE_NAME],[DOC_TYPE_ID],[ORDER_CONTEXT],[SEASON],[REASON],[UNITS],[TOTAL_QUANTITIES],[TOTAL_BASE_PRICE],[TOTAL_MSRP_PRICE],[TOTAL_MAP_PRICE],[TOTAL_NET_PRICE],[DELTA_FLAG],[SUBMITTED_CART_ID]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)" ;
		Object[] parms = {
			cart.getDocCatagoryId(),
			cart.getMethodCodeId(),
			cart.getCustomerNumber(),
			cart.getShipToNumber(),
			cart.getSalesDocName(),
			cart.getCustomerPoNumber(),
			cart.getRequestedDeliveryDt(),
			cart.getCancelDt(),
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
			cart.getCreatedOn(),
			cart.getLastUpdateBy(),
			cart.getLastUpdateOn(),
			cart.getNotes(),
			cart.getValidFrom(),
			cart.getValidTo(),
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
			cart.getSubmittedCartId()
		} ;
		logger.info("Executing : " + sql0);
		template.update(sql0, parms) ;
		
		String sql1 = "SELECT MAX(draft_salesdoc_header_id) FROM [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_HEADER]" ;
		logger.info("Executing : " + sql1);
		return template.queryForInt(sql1) ;
	}
	
	@Override
	public List<Map<String, String>> insertCartProducts(List<CartProduct> cartProducts, Integer cartId){
		String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_MAPPING]([DRAFT_SALESDOC_HEADER_ID],[PRODUCT_NUMBER],[GENDER_FIT],[STYLE],[CREATEDBY],[CREATEDDATETIME],[MODIFIEDBY],[MODIFIEDDATETIME],[DIMENSION],[RDD],[UOM],[LINE_ITEM_NO],[DLV_GROUP],[AUTOALLOCATION],[BRAND],[SALES_ORG],[DISTRIBUTION_CHANNEL],[SEASON],[SEQUENCE],[BASE_PRICE],[MSRP_PRICE],[MAP_PRICE],[NET_PRICE],[DISCOUNT],[DISCOUNT_PERCENT],[QUANTITIES],[TOTAL_BASE_PRICE],[TOTAL_MSRP_PRICE],[TOTAL_MAP_PRICE],[TOTAL_NET_PRICE])VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		for(CartProduct cp : cartProducts){
			Object[] parms = {
				cp.getDraftSalesDocHeaderId(),
				cp.getProductNumber(),
				cp.getGenderFit(),
				cp.getStyle(),
				cp.getCreatedBy(),
				cp.getCreatedDateTime(),
				cp.getModifiedBy(),
				cp.getModifiedDateTime(),
				cp.getDimenison(),
				cp.getRequestedDeliveryDate(),
				cp.getUnitOfMeasure(),
				cp.getLineItemNo(),
				cp.getDlvGroup(),
				cp.getAutoAllocation(),
				cp.getBrand(),
				cp.getSalesOrg(),
				cp.getDistrubutionChannel(),
				cp.getSeason(),
				cp.getSequence(),
				cp.getBasePrice(),
				cp.getMsrpPrice(),
				cp.getMapPrice(),
				cp.getNetPrice(),
				cp.getDiscount(),
				cp.getDiscountPercent(),
				cp.getQuantities(),
				cp.getTotalBasePrice(),
				cp.getTotalMsrpPrice(),
				cp.getTotalMapPrice(),
				cp.getTotalNetPrice()
			} ;
			
			logger.info("Executing : " + sql0) ;
			template.update(sql0, parms) ;
		}
		
		String sql1 = "SELECT id, product_number FROM cc_draft_salesdoc_product_mapping WHERE draft_salesdoc_header_id = " + cartId ;
		logger.info("Executing : " + sql1);
		List<Map<String, String>> list = template.query(sql1, new GenericRowMapper()) ;
		
		return list ;
	}

	@Override
	public List<Map<String, String>> insertCartProductSizes(List<CartProductSize> cartProductSizes){
		String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_MAPPING]([SALESDOC_PRODUCT_ID],[SIZE],[QUANTITY],[DIMENSION],[CREATEDBY],[CREATEDDATETIME],[MODIFIEDBY],[MODIFIEDDATETIME])VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;

		String sdpids = "" ;
		
		for(CartProductSize cps : cartProductSizes){
			Object[] parms = {
				cps.getSalesDocProductId(),
				cps.getSize(),
				cps.getQuantity(),
				cps.getDimension(),
				cps.getCreatedBy(),
				cps.getCreatedDateTime(),
				cps.getModifiedBy(),
				cps.getModifiedDateTime()
			} ;
		
			sdpids += cps.getSalesDocProductId() + "," ;
			logger.info("Executing: " + sql0);
			template.update(sql0, parms) ;
		}
		
		String sql1 = "SELECT id, salesdoc_product_id FROM cc_draft_salesdoc_product_size_mapping where salesdoc_product_id in (" + sdpids + ")" ;
		logger.info("Executing: " + sql1);
		List<Map<String, String>> list = template.query(sql1, new GenericRowMapper()) ;
		logger.info("Result: " + list);
		return list ;
		
	}
	
	@Override
	public List<Map<String, String>> insertCartProductSizeRdds(List<CartProductSizeRdd> cartProductSizeRdds){
		String sql0 = "INSERT INTO [BXCONNECT_AFS].[dbo].[CC_DRAFT_SALESDOC_PRODUCT_SIZE_RDD_MAPPING]([PRODUCT_SIZE_ID],[QUANTITY],[RDD],[ORIGINAL_RDD]) VALUES (?, ?, ?, ?)" ;
		
		String pids = "" ;
		for(CartProductSizeRdd cpsr : cartProductSizeRdds){
			Object[] parms = {
				cpsr.getProductSizeId(),
				cpsr.getQuantity(),
				cpsr.getRequestedDeliveryDate(),
				cpsr.getOriginalRequestedDeliveryDate()
			};
			
			pids += cpsr.getProductSizeId() + "," ;
			logger.info("Executing: " + sql0) ;
			template.update(sql0, parms) ;
		}
		
		String sql1 = "SELECT id, product_size_id FROM cc_draft_salesdoc_product_size_rdd_mapping WHERE product_size_id IN (" + pids + ")" ;
		logger.info("Executing: " + sql1);
		List<Map<String, String>> list = template.query(sql1, new GenericRowMapper()) ;
		logger.info("Result: " + list);
		return list ;
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
		logger.debug("Mapping result set values");
		for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
			key = rs.getMetaData().getColumnName(i) ;
			value = rs.getString(i) ;
			logger.debug("Storing {" + key + ", " + value + "}") ;
			m.put(key, value) ;
		}
		logger.debug("Returning " + m) ;
		return m ;
	}
	
}
