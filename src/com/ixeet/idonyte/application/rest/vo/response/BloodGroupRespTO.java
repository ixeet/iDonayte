package com.ixeet.idonyte.application.rest.vo.response;


import org.codehaus.jackson.map.annotate.JsonSerialize;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)

public class BloodGroupRespTO {
	
	private String bloodGroupId;
	private String bloodGroupName;
	
	
	public BloodGroupRespTO(String bloodGroupId, String bloodGroupName) {
		super();
		this.bloodGroupId = bloodGroupId;
		this.bloodGroupName = bloodGroupName;
		
	}
	public String getBloodGroupId() {
		return bloodGroupId;
	}
	public void setBloodGroupId(String bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}
	public String getBloodGroupName() {
		return bloodGroupName;
	}
	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
	

}
