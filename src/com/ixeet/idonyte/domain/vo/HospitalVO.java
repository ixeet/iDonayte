package com.ixeet.idonyte.domain.vo;

public class HospitalVO {
	
	private int hospitalId;
	private String hospitalNm;
	private String hospitalAddress1;
	private String hospitalAddress2;
	private String area;
	private String district;
	private String state;
	private String contactNo1;
	private String contactNo2;
	private String lat;
	private String lon;
	private String lastUpdtTm;
	
	public HospitalVO() {
		super();
	}
	public HospitalVO(int hospitalId, String hospitalNm) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalNm = hospitalNm;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalNm() {
		return hospitalNm;
	}
	public void setHospitalNm(String hospitalNm) {
		this.hospitalNm = hospitalNm;
	}
	public String getHospitalAddress1() {
		return hospitalAddress1;
	}
	public void setHospitalAddress1(String hospitalAddress1) {
		this.hospitalAddress1 = hospitalAddress1;
	}
	public String getHospitalAddress2() {
		return hospitalAddress2;
	}
	public void setHospitalAddress2(String hospitalAddress2) {
		this.hospitalAddress2 = hospitalAddress2;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContactNo1() {
		return contactNo1;
	}
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}
	public String getContactNo2() {
		return contactNo2;
	}
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLastUpdtTm() {
		return lastUpdtTm;
	}
	public void setLastUpdtTm(String lastUpdtTm) {
		this.lastUpdtTm = lastUpdtTm;
	}


}
