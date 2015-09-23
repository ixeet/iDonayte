/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.bus.impl;

import java.util.ArrayList;
import java.util.List;

import com.ixeet.idonyte.application.rest.bus.iface.UserBusIface;
import com.ixeet.idonyte.application.rest.constants.AppRestConstants;
import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.request.UserRequest;
import com.ixeet.idonyte.application.rest.vo.response.StateRespTO;
import com.ixeet.idonyte.application.rest.vo.response.UserResponse;
import com.ixeet.idonyte.domain.vo.CommonKeyValueVO;
import com.ixeet.idonyte.domain.vo.UserTO;
import com.ixeet.idonyte.persistance.dao.iface.CommonDao;
import com.ixeet.idonyte.persistance.dao.iface.UserDao;
import com.ixeet.idonyte.persistance.dao.impl.CommonDaoImpl;
import com.ixeet.idonyte.persistance.dao.impl.UserDaoImpl;


/**
 *
 * @author dell
 */
public class UserBusImpl implements UserBusIface{
	UserDao dao=new UserDaoImpl();

	public UserResponse donarRegistration(UserRequest req)
			throws RestBusException {
        UserResponse resp = new UserResponse();
        
        try {
        	
        	UserTO user=getUserFromReq(req);
        	 //Verify if user Exist or not
        	if(dao.isDonarExist(user)==false)
        	{
        	//Save 
        		dao.donarRegistration(user);
                resp.setStatus(AppRestConstants.status_success);
                resp.setStatusMessage(AppRestConstants.message_success);  
        	}else{
                resp.setStatus(AppRestConstants.status_userExist);
                resp.setStatusMessage(AppRestConstants.message_userExist);          		
        	}

        } catch (Exception ex) {
            System.out.println("Exception # donarRegistration "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;

	}
	

	public UserResponse receiverRegistration(UserRequest req)
			throws RestBusException {
        UserResponse resp = new UserResponse();
        
        try {
        	
        	UserTO user=getUserFromReq(req);
        	 //Verify if user Exist or not
        	if(dao.isReceiverExist(user)==false)
        	{
        	//Save 
        		dao.receiverRegistration(user);
                resp.setStatus(AppRestConstants.status_success);
                resp.setStatusMessage(AppRestConstants.message_success);  
        	}else{
                resp.setStatus(AppRestConstants.status_userExist);
                resp.setStatusMessage(AppRestConstants.message_userExist);          		
        	}

        } catch (Exception ex) {
            System.out.println("Exception # receiverRegistration "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;

	}
	

	public UserResponse setUserDonated(int userId) throws RestBusException {
        UserResponse resp = new UserResponse();
        
        try {
    		dao.setUserDonated(userId);
    		    		
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  

        } catch (Exception ex) {
            System.out.println("Exception # setUserDonated "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;

	}


	public UserResponse setRecieved(int userId) throws RestBusException {
        UserResponse resp = new UserResponse();
        
        try {
    		dao.setRecieved(userId);
    		    		
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  

        } catch (Exception ex) {
            System.out.println("Exception # setRecieved "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;
	}

	
	
	public UserResponse setFBId(int userId, String facebookId,String userType)
			throws RestBusException {
		UserResponse resp = new UserResponse();
		
        try {
    		dao.setFBId(userId, facebookId,userType);
    		    		
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  

        } catch (Exception ex) {
            System.out.println("Exception # setFBId "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;
	}



	public UserResponse getUserDetail(String contactNo) throws RestBusException {
		UserResponse resp = new UserResponse();
		
        try {
        	//Set states list
        	CommonDao commonDao = new CommonDaoImpl();
        	List<CommonKeyValueVO> stateListFromDB = commonDao.getStateList();
        	List<StateRespTO> stateList=new ArrayList<StateRespTO>(stateListFromDB.size());
        	StateRespTO stateTo;
        	for(CommonKeyValueVO state:stateListFromDB)
        	{
        		stateTo = new StateRespTO(state.getItemCode(), state.getItemName());
        		stateList.add(stateTo);
        	}
        	resp.setStateList(stateList);
        	
        	//Set user details
        	UserTO user=dao.getUser(contactNo);
    		    		
        	if(user!=null)
        	{
        	resp.setUserDetail(user);	
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  
        	}
        	else
        	{
            resp.setStatus(AppRestConstants.status_userNotExist);
            resp.setStatusMessage(AppRestConstants.message_userNotExist);          		
        	}
        } catch (Exception ex) {
            System.out.println("Exception # getUserDetail "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;
	}
	
	/**
	 * Returns records based on search text.
	 * 
	 * Request parameters - lat,lon,searchText,offset,noOfRecords
	 * 
	 */
	public UserResponse search(UserRequest req)
			throws RestBusException {
		UserResponse resp = new UserResponse();
		
        try {
        	//lat,lon,searchText,offset,noOfRecords
        	List<UserTO> userList=dao.search(req.getLat(),req.getLon(), req.getSearchText(),req.getOffset(),req.getNoOfRecords());
    		
        	if(userList.size()>0)
        	{
        	resp.setUsersList(userList);	
            resp.setStatus(AppRestConstants.status_success);
            resp.setStatusMessage(AppRestConstants.message_success);  
        	}
        	else
        	{
                resp.setStatus(AppRestConstants.status_success);
                resp.setStatusMessage(AppRestConstants.message_success);     
                resp.setErrorMessage(AppRestConstants.message_recordnotfound);
        	}
        } catch (Exception ex) {
            System.out.println("Exception # search "+ex.getMessage());
            resp.setStatus(AppRestConstants.status_failure);
            resp.setStatusMessage(AppRestConstants.message_failure);
            resp.setErrorMessage(ex.getMessage());
        }
       
        return resp;
	}
	
	
	
//////////////COMMON METHOD///////////////////////
	
	private UserTO getUserFromReq(UserRequest req){
    	UserTO user=new UserTO();
    	user.setUserId(req.getUserId());
    	user.setFirstName(req.getFirstName());
    	user.setLastName(req.getLastName());
    	user.setAddress1(req.getAddress1());
    	user.setAddress2(req.getAddress2());
    	user.setArea(req.getArea());
    	user.setState(req.getState());
    	user.setBloodGroup(req.getBloodGroup());
    	user.setContactNo(req.getContactNo());
    	user.setDistrict(req.getDistrict());
    	user.setFacebookId(req.getFacebookId());
    	user.setIsDonor(req.getIsDonor());
    	user.setLat(req.getLat());
    	user.setLon(req.getLon());
    	user.setLocation(req.getLocation());
    	user.setEmailDispFlag(req.getEmailDispFlag());
    	user.setContactNoDispFlag(req.getContactNoDispFlag());
    	user.setDateOfBirth(req.getDateOfBirth());
    	user.setIsDonated(req.getIsDonated());
    	user.setGender(req.getGender());
    	user.setLastDonatedDate(req.getLastDonatedDate());
    	user.setBloodGroupId(req.getBloodGroupId());    	
    	user.setDonateTypeId(req.getDonateTypeId());
    	user.setEmail(req.getEmail());
    	
    	return user;
	}

	
    
}//End of class
