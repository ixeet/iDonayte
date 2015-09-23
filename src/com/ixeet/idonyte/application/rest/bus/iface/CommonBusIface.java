/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.bus.iface;

import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.response.CommonResponse;


/**
 *
 * @author dell
 */
public interface CommonBusIface {
	
	CommonResponse getDistrictList(int stateId) throws RestBusException;
	CommonResponse getHospitalsList(String searchtxt) throws RestBusException;

    
}
