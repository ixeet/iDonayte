package com.ixeet.idonyte.application.rest.vo.response;

public class AreaRespTO {
	
	private String areaId;
	private String areaName;
	
	
	
	public AreaRespTO(String areaId, String areaName) {
		super();
		this.areaId = areaId;
		this.areaName = areaName;
	}
	
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	

}
