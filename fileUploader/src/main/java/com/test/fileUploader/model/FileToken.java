package com.test.fileUploader.model;

public class FileToken {
	private String fileName;
	private String contenType;
	private String downloadUrl;
	public FileToken() {
		super();
			}
	public FileToken(String fileName, String contenType, String downloadUrl) {
		super();
		this.fileName = fileName;
		this.contenType = contenType;
		this.downloadUrl = downloadUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContenType() {
		return contenType;
	}
	public void setContenType(String contenType) {
		this.contenType = contenType;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	@Override
	public String toString() {
		return "FileToken [fileName=" + fileName + ", contenType=" + contenType + ", downloadUrl=" + downloadUrl + "]";
	}
	
	

}
