/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.domain.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author dell
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserTO {

	private String firstName;
	private String lastName;
	private String contactNo;
	private String address1;
	private String address2;
	private String area;
	private String district;
	private String state;
	private String lat;
	private String lon;
	private String bloodGroup;
	private String isDonor;
	private String searchText;
	private String location;
	private int userId;
	private String facebookId;
	private String lastUpdate;
	private String email;
	private String relation;
	private String isDonated;
	private String isReceived;

	private String gender;
	private String contactNoDispFlag;
	private String emailDispFlag;
	private String dateOfBirth;
	private String lastDonatedDate;
	private int bloodGroupId;
	private int donateTypeId;
	private String userType;

	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public int getDonateTypeId() {
		return donateTypeId;
	}

	public void setDonateTypeId(int donateTypeId) {
		this.donateTypeId = donateTypeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNoDispFlag() {
		return contactNoDispFlag;
	}

	public void setContactNoDispFlag(String contactNoDispFlag) {
		this.contactNoDispFlag = contactNoDispFlag;
	}

	public String getEmailDispFlag() {
		return emailDispFlag;
	}

	public void setEmailDispFlag(String emailDispFlag) {
		this.emailDispFlag = emailDispFlag;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLastDonatedDate() {
		return lastDonatedDate;
	}

	public void setLastDonatedDate(String lastDonatedDate) {
		this.lastDonatedDate = lastDonatedDate;
	}

	public String getIsReceived() {
		return isReceived;
	}

	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	public String getIsDonated() {
		return isDonated;
	}

	public void setIsDonated(String isDonated) {
		this.isDonated = isDonated;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getIsDonor() {
		return isDonor;
	}

	public void setIsDonor(String isDonor) {
		this.isDonor = isDonor;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "UserTO [firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNo=" + contactNo + ", address1=" + address1
				+ ", address2=" + address2 + ", area=" + area + ", district="
				+ district + ", state=" + state + ", lat=" + lat + ", lon="
				+ lon + ", bloodGroup=" + bloodGroup + ", isDonor=" + isDonor
				+ ", searchText=" + searchText + ", location=" + location
				+ ", userId=" + userId + ", facebookId=" + facebookId
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
