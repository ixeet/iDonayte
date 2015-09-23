package com.ixeet.idonyte.application.rest.vo.response;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class StateRespTO {

	private String stateId;
	private String stateName;
	
	private List<DistrictRespTO> districtList;
	
	

	public StateRespTO() {
		super();
	}

	public StateRespTO(String stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<DistrictRespTO> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<DistrictRespTO> districtList) {
		this.districtList = districtList;
	}
	
	
}
