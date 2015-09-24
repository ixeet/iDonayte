/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.ixeet.idonyte.application.rest.bus.iface.UserBusIface;
import com.ixeet.idonyte.application.rest.bus.impl.UserBusImpl;
import com.ixeet.idonyte.application.rest.constants.AppRestConstants;
import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.request.UserRequest;
import com.ixeet.idonyte.application.rest.vo.response.UserResponse;


/**
 *
 * @author dell
 */
@Path("/user")
public class UserController {
	UserBusIface restService = new UserBusImpl();
    /**
     * Default controller method
     * @return 
     */
    @GET
    public String defaultx() {
        String message = "Welcome to iDonyte webservices....";
        return message;
    }
   

    /**
     * Donar registration service.
     * 
     * @param UserRequest
     * @param HttpServletRequest
     * @return UserResponse
     */
    @POST
    @Path("/registeration/donar")
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)      
    public UserResponse donarRegistration(UserRequest req,@Context HttpServletRequest request) {
        System.out.println("Start donarRegistration >> req = "+req);
        UserResponse resp = null;
        
        try {
    /*    	resp = new UserResponse();
          	if(req.getFirstName() == null || (req.getFirstName() != null && req.getFirstName().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_FirstNameRequired);    //First name validation
        	} 
          	else if(req.getLastName() == null || (req.getLastName() != null && req.getLastName().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_LastNameRequired);    //Last name validation
        	} 
        	else if(req.getGender() == null || (req.getGender() != null && req.getGender().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_GenderRequired);    //Gender validation
        	} 
        	else if(req.getDateOfBirth() == null || (req.getDateOfBirth() != null && req.getDateOfBirth().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_DateOfBirthRequired);    //DateOfBirth validation
        	}   
        	else if(req.getContactNo() == null || (req.getContactNo() != null && req.getContactNo().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_ContactRequired);    //Contact No validation
        	} 
        	else if(req.getEmail() == null || (req.getEmail() != null && req.getEmail().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_EmailRequired);    //Email validation
        	} 
        	else if(req.getBloodGroupId() == 0 )
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_BloodGroupIdRequired);    //Blood Group Id validation
        	} 
        	else if(req.getDonateTypeId() == 0 )
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_DonateTypeIdRequired);    //Donate Type Id validation
        	}        	
        	else if(req.getAddress1() == null || (req.getAddress1() != null && req.getAddress1().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AddressRequired);    //Adress1 validation
        	} 
        	else if(req.getAddress2() == null || (req.getAddress2() != null && req.getAddress2().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AddressRequired);    //Adress2 validation
        	} 
        	else if(req.getArea() == null || (req.getArea() != null && req.getArea().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AreaRequired);    //Area validation
        	} 
        	else if(req.getDistrict() == null || (req.getDistrict() != null && req.getDistrict().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_DistrictRequired);    //District validation
        	}
        	else if(req.getState() == null || (req.getState() != null && req.getState().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_StateRequired);    //State validation
        	}  
        	else if(req.getLat() == null || (req.getLat() != null && req.getLat().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_latRequired);    //Lat validation
        	} 
        	else if(req.getLon() == null || (req.getLon() != null && req.getLon().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_lonRequired);    //Lon validation
        	} 
        	else if(req.getEmailDispFlag() == null || (req.getEmailDispFlag() != null && req.getEmailDispFlag().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_EmailDispFlagRequired);    //EmailDispFlag validation
        	}
        	else if(req.getContactNoDispFlag() == null || (req.getContactNoDispFlag() != null && req.getContactNoDispFlag().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_ContactDispFlagRequired);    //ContactDispFlag validation
        	}
        	else
        	{*/
                resp = restService.donarRegistration(req);
        	//}
        } catch (RestBusException ex) {
            System.out.println("Exception # donarRegistration - "+ex);
        }
        
        System.out.println("<< End donarRegistration # "); 
        return resp;
    }
    

    /**
     * Donar registration service.
     * 
     * @param UserRequest
     * @param HttpServletRequest
     * @return UserResponse
     */
    @POST
    @Path("/registeration/receiver")
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)      
    public UserResponse receiverRegistration(UserRequest req,@Context HttpServletRequest request) {
        System.out.println("Start receiverRegistration >> req = "+req);
        UserResponse resp = null;
        
        try {
        	/*resp = new UserResponse();
         	if(req.getFirstName() == null || (req.getFirstName() != null && req.getFirstName().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_FirstNameRequired);    //First name validation
        	} 
          	else if(req.getLastName() == null || (req.getLastName() != null && req.getLastName().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_LastNameRequired);    //Last name validation
        	} 
        	else if(req.getContactNo() == null || (req.getContactNo() != null && req.getContactNo().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_ContactRequired);    //Contact No validation
        	} 
        	else if(req.getBloodGroupId() == 0 )
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_BloodGroupIdRequired);    //Blood Group Id validation
        	} 
        	else if(req.getDonateTypeId() == 0 )
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_DonateTypeIdRequired);    //Donate Type Id validation
        	}  
        	else if(req.getAddress1() == null || (req.getAddress1() != null && req.getAddress1().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AddressRequired);    //Adress1 validation
        	} 
        	else if(req.getAddress2() == null || (req.getAddress2() != null && req.getAddress2().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AddressRequired);    //Adress2 validation
        	} 
        	else if(req.getArea() == null || (req.getArea() != null && req.getArea().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_AreaRequired);    //Area validation
        	} 
        	else if(req.getDistrict() == null || (req.getDistrict() != null && req.getDistrict().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_DistrictRequired);    //District validation
        	}
        	else if(req.getState() == null || (req.getState() != null && req.getState().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_StateRequired);    //State validation
        	}  
        	else if(req.getLat() == null || (req.getLat() != null && req.getLat().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_latRequired);    //Lat validation
        	} 
        	else if(req.getLon() == null || (req.getLon() != null && req.getLon().trim().isEmpty()))
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_lonRequired);    //Lon validation
        	}
        	else
        	{*/
                resp = restService.receiverRegistration(req);
        	//}
        } catch (RestBusException ex) {
            System.out.println("Exception # receiverRegistration - "+ex);
        }
        
        System.out.println("<< End receiverRegistration # "); 
        return resp;
    }
    
    
    /**
     * Set user status as blood donated.
     * @param userId
     * @param fbId
     * @return
     */
    @GET
    @Path("/setDonated/userId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse setUserDonated(@PathParam("userId") int userId) {
        System.out.println("Start setUserDonated >> userId = "+userId);
        UserResponse userResponse = null;
        
        try {
        	userResponse = new UserResponse();
/*       	 if(userId == 0 )
       	{
       		 userResponse.setStatus(AppRestConstants.status_fieldRequired);
       		 userResponse.setStatusMessage(AppRestConstants.message_fieldRequired);
       		 userResponse.setErrorMessage(AppRestConstants.message_UserIdRequired);    //user Id validation
       	} 
       	 else{*/
            userResponse = restService.setUserDonated(userId);
       	// }
        } catch (RestBusException ex) {
            System.out.println("Exception # setUserDonated - "+ex);
        }
        
        System.out.println("<< End setUserDonated # "); 
        return userResponse;
    }
    
    
    
    /**
     * Set user status as blood received.
     * @param userId
     * @return
     */
    @GET
    @Path("/setRecieved/userId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse setRecieved(@PathParam("userId") int userId) {
        System.out.println("Start setRecieved >> userId = "+userId);
        UserResponse userResponse = null;
        
        try {
/*        	userResponse = new UserResponse();
       	 if(userId == 0 )
       	{
       		 userResponse.setStatus(AppRestConstants.status_fieldRequired);
       		 userResponse.setStatusMessage(AppRestConstants.message_fieldRequired);
       		 userResponse.setErrorMessage(AppRestConstants.message_UserIdRequired);    //user Id validation
       	} 
       	 else
       	 {*/
            userResponse = restService.setRecieved(userId);
       	 //}
        } catch (RestBusException ex) {
            System.out.println("Exception # setRecieved - "+ex);
        }
        
        System.out.println("<< End setRecieved # "); 
        return userResponse;
    }
    
    
    /**
     * Update facebook id into database. 
     * @param userId
     * @param userFbId
     * @return UserResponse
     */
    @GET
    @Path("/setFBId/userId/{userId}/userFbId/{fbId}/userType/{userType}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse setFBId(@PathParam("userId") int userId,@PathParam("fbId") String fbId,@PathParam("userType") String userType) {
        System.out.println("Start setFBId >> userId = "+userId);
        UserResponse userResponse = null;
        
        try {
        	userResponse = new UserResponse();
/*       	 if(userId == 0 )
       	{
       		 userResponse.setStatus(AppRestConstants.status_fieldRequired);
       		 userResponse.setStatusMessage(AppRestConstants.message_fieldRequired);
       		 userResponse.setErrorMessage(AppRestConstants.message_UserIdRequired);    //user Id validation
       	} 
     	else if(fbId == null || (fbId != null && fbId.trim().isEmpty()))
     	{
     		userResponse.setStatus(AppRestConstants.status_fieldRequired);
     		userResponse.setStatusMessage(AppRestConstants.message_fieldRequired);
     		userResponse.setErrorMessage(AppRestConstants.message_FacebookIdRequired);    //fbId validation
     	}
       	 else
       	 {*/
            userResponse = restService.setFBId(userId,fbId,userType);
       	 //}
        } catch (RestBusException ex) {
            System.out.println("Exception # setFBId - "+ex);
        }
        
        System.out.println("<< End setFBId # "); 
        return userResponse;
    }
        
    
    /**
     * Set user status as blood received.
     * @param userId
     * @return
     */
    @GET
    @Path("/getDetail/contactNo/{contactNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse getUserDetail(@PathParam("contactNo") String contactNo) {
        System.out.println("Start getUserDetail >> contactNo = "+contactNo);
        UserResponse userResponse = null;
        
        try {
/*        	userResponse = new UserResponse();
       	 if(contactNo == null || (contactNo != null && contactNo.trim().isEmpty()))
       	{
       		 userResponse.setStatus(AppRestConstants.status_fieldRequired);
       		 userResponse.setStatusMessage(AppRestConstants.message_fieldRequired);
       		 userResponse.setErrorMessage(AppRestConstants.message_ContactRequired);    //Contact validation
       	} 
       	 else
       	 {*/
            userResponse = restService.getUserDetail(contactNo);
       	 //}         		
        } catch (RestBusException ex) {
            System.out.println("Exception # getUserDetail - "+ex);
        }
        
        System.out.println("<< End getUserDetail # "); 
        return userResponse;
    }    
    
    
    /**
     * Search Response.
     * @param [LAT | LON | searchText | offset | noOfRecords]
     * @param searchText
     * @return UserResponse
     */
    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse search(UserRequest req,@Context HttpServletRequest request) {
        System.out.println("search >> req = "+req);
        UserResponse resp = new UserResponse();
        
        try {
        	if(req.getNoOfRecords() <= 0)
        	{
        		resp.setStatus(AppRestConstants.status_fieldRequired);
        		resp.setStatusMessage(AppRestConstants.message_fieldRequired);
        		resp.setErrorMessage(AppRestConstants.message_noOfRecordsRequired);    //noOfRecords validation
        	}
        	else
        	{
        		resp = restService.search(req); 
        	}        	
            
        } catch (RestBusException ex) {
            System.out.println("Exception # search - "+ex);
        }
        
        System.out.println("<< End search # "+resp); 
        return resp;
    }
        
    
    
    
    
}//End of class
