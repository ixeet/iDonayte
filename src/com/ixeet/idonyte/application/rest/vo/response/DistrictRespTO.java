package com.ixeet.idonyte.application.rest.vo.response;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class DistrictRespTO {

	private String districtId;
	private String districtName;
	
	private List<AreaRespTO> areaList;

	
	
	public DistrictRespTO() {
		super();
	}

	public DistrictRespTO(String districtId, String districtName) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public List<AreaRespTO> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<AreaRespTO> areaList) {
		this.areaList = areaList;
	}
	
	
}
