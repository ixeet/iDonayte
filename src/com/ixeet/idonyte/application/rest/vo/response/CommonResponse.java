package com.ixeet.idonyte.application.rest.vo.response;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CommonResponse extends CommonRespTO{
	private List<StateRespTO> stateList;
	private List<DistrictRespTO> districtList;
	
	
	public List<StateRespTO> getStateList() {
		return stateList;
	}
	public void setStateList(List<StateRespTO> stateList) {
		this.stateList = stateList;
	}
	public List<DistrictRespTO> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(List<DistrictRespTO> districtList) {
		this.districtList = districtList;
	}
	
	
	

}
