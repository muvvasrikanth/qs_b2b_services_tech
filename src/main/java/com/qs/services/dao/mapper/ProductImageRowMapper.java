package com.qs.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qs.services.domain.ProductImage;

public class ProductImageRowMapper implements RowMapper<ProductImage> {

	@Override
	public ProductImage mapRow(ResultSet rs, int row) throws SQLException {
		ProductImage pi = new ProductImage() ;
		
		pi.setId(rs.getInt("ID"));
		pi.setStyleNumber(rs.getString("STYLE_NUMBER"));
		pi.setColorCode(rs.getString("COLOR_CODE"));
		pi.setSize(rs.getInt("SIZE"));
		pi.setAngle(rs.getString("ANGLE")) ;
		pi.setCad(rs.getBoolean("CAD"));
		pi.setLinebook(rs.getBoolean("LINEBOOK"));
		pi.setFileName(rs.getString("FILE_NAME")) ;
		pi.setS3Path(rs.getString("S3_PATH"));
		pi.setUploadDate(rs.getDate("UPLOAD_DATE"));
		pi.setJobCode(rs.getString("JOB_CODE"));
		pi.setCreatedDateTime(rs.getDate("CREATED_DATETIME"));
		pi.setModifiedDateTime(rs.getDate("MODIFIED_DATETIME"));
		pi.setImageType(rs.getString("IMAGE_TYPE"));
		pi.setOldJobCode(rs.getString("OLD_JOB_CODE"));
		pi.setMaterialNumber(rs.getString("MATERIAL_NUMBER")) ;
		
		return pi ;
	}

}
