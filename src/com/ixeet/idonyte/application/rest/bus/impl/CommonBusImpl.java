package com.ixeet.idonyte.application.rest.bus.impl;

import java.util.ArrayList;
import java.util.List;

import com.ixeet.idonyte.application.rest.bus.iface.CommonBusIface;
import com.ixeet.idonyte.application.rest.constants.AppRestConstants;
import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.request.CommonRequest;
import com.ixeet.idonyte.application.rest.vo.response.AreaRespTO;
import com.ixeet.idonyte.application.rest.vo.response.CommonResponse;
import com.ixeet.idonyte.application.rest.vo.response.DistrictRespTO;
import com.ixeet.idonyte.domain.vo.CommonKeyValueVO;
import com.ixeet.idonyte.domain.vo.HospitalVO;
import com.ixeet.idonyte.persistance.dao.iface.CommonDao;
import com.ixeet.idonyte.persistance.dao.impl.CommonDaoImpl;



public class CommonBusImpl implements CommonBusIface {

	@Override
	public CommonResponse getDistrictList(int stateId) throws RestBusException {
		CommonResponse resp = new CommonResponse();
		
        try {
        	CommonDao dao = new CommonDaoImpl();
        	List<CommonKeyValueVO> distListFromDb=dao.getDistrictList(stateId);
        	List<DistrictRespTO> districtList = new ArrayList<DistrictRespTO>(distListFromDb.size());
        	DistrictRespTO distTo=null;
        	for(CommonKeyValueVO dist:distListFromDb)
        	{
        		distTo = new DistrictRespTO(dist.getItemCode(),dist.getItemName());
        		//Get Area list
            	List<CommonKeyValueVO> areaListFromDb=dao.getAreaList(Integer.parseInt(dist.getItemCode()));
            	List<AreaRespTO> areaList = new ArrayList<AreaRespTO>(areaListFromDb.size());     
            	AreaRespTO areaTo=null;
        		for(CommonKeyValueVO area:areaListFromDb)
        		{
        			areaTo = new AreaRespTO(area.getItemCode(), area.getItemName());
        			areaList.add(areaTo);
        		}
            	
        		//set area list
            	distTo.setAreaList(areaList);
            	districtList.add(distTo);
        	}
        	
        	resp.setDistrictList(districtList);
        	//Common resp
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  
        } catch (Exception ex) {
            System.out.println("Exception # getDistrictList "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;

	}

	@Override
	public CommonResponse getHospitalsList(CommonRequest req) throws RestBusException {
		CommonResponse resp = new CommonResponse();
        try {
        	CommonDao dao = new CommonDaoImpl();
        	List<HospitalVO> hospitalList=dao.getHospitalList(req.getSearchtxt());
            	
        	resp.setHospitalList(hospitalList);
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  
        } catch (Exception ex) {
            System.out.println("Exception # getHospitalList "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
		return resp;
	}


}//End of class
