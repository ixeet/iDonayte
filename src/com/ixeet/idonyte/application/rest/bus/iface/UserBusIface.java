/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.bus.iface;

import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.request.UserRequest;
import com.ixeet.idonyte.application.rest.vo.response.UserResponse;


/**
 *
 * @author dell
 */
public interface UserBusIface {
	UserResponse donarRegistration(UserRequest req) throws RestBusException;
	UserResponse receiverRegistration(UserRequest req) throws RestBusException;
	UserResponse setUserDonated(int userId) throws RestBusException;
	UserResponse setRecieved(int userId) throws RestBusException;
	UserResponse setFBId(int userId,String facebookId,String userType) throws RestBusException;
	UserResponse getUserDetail(String contactNo) throws RestBusException;
	UserResponse search(UserRequest req) throws RestBusException;
    
}
