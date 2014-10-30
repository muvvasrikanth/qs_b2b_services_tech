package com.qs.services.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ProductImage {

	@JsonProperty("ID")
	private Integer id ;
	
	@JsonProperty("STYLE_NUMBER")
	private String styleNumber ;
	
	@JsonProperty("COLOR_CODE")
	private String colorCode ;
	
	@JsonProperty("SIZE")
	private Integer size ;
	
	@JsonProperty("ANGLE")
	private String angle ;
	
	@JsonProperty("CAD")
	private Boolean cad ;
	
	@JsonProperty("LINEBOOK")
	private Boolean linebook ;
	
	@JsonProperty("FILE_NAME")
	private String fileName ;
	
	@JsonProperty("S3_PATH")
	private String s3Path ;
	
	@JsonProperty("UPLOAD_DATE")
	private Date uploadDate ;
	
	@JsonProperty("JOB_CODE")
	private String jobCode ;
	
	@JsonProperty("CREATED_DATETIME")
	private Date createdDateTime ;
	
	@JsonProperty("MODIFIED_DATETIME")
	private Date modifiedDateTime ;
	
	@JsonProperty("IMAGE_TYPE")
	private String imageType ;
	
	@JsonProperty("OLD_JOB_CODE")
	private String oldJobCode ;
	
	@JsonProperty("MATERIAL_NUMBER")
	private String materialNumber ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStyleNumber() {
		return styleNumber;
	}

	public void setStyleNumber(String styleNumber) {
		this.styleNumber = styleNumber;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getAngle() {
		return angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}

	public Boolean getCad() {
		return cad;
	}

	public void setCad(Boolean cad) {
		this.cad = cad;
	}

	public Boolean getLinebook() {
		return linebook;
	}

	public void setLinebook(Boolean linebook) {
		this.linebook = linebook;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getS3Path() {
		return s3Path;
	}

	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getOldJobCode() {
		return oldJobCode;
	}

	public void setOldJobCode(String oldJobCode) {
		this.oldJobCode = oldJobCode;
	}

	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	
	
}
