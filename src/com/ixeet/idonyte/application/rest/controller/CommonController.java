/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ixeet.idonyte.application.rest.bus.iface.CommonBusIface;
import com.ixeet.idonyte.application.rest.bus.impl.CommonBusImpl;
import com.ixeet.idonyte.application.rest.exceptions.RestBusException;
import com.ixeet.idonyte.application.rest.vo.response.CommonResponse;

/**
 *
 * @author dell
 */
@Path("/common")
public class CommonController {
	CommonBusIface restService = new CommonBusImpl();
	
    /**
     * Default controller method
     * @return 
     */
    @GET
    public String defaultx() {
        String message = "Welcome to iDonyte common webservices....";
        return message;
    }
   
    
    @GET
    @Path("/getDistricts/stateId/{stateId}")
    @Produces(MediaType.APPLICATION_JSON)
    public CommonResponse getDistricts(@PathParam("stateId") int stateId) {
        System.out.println("Start getDistricts >> stateId = "+stateId);
        CommonResponse resp = null;
        
        try {
        	resp = restService.getDistrictList(stateId);
        } catch (RestBusException ex) {
            System.out.println("Exception # getDistricts - "+ex);
        }
        
        System.out.println("<< End getDistricts # "); 
        return resp;
    }    
    
   
    
    @GET
    @Path("/getHospitals/search/{searchtxt}")
    @Produces(MediaType.APPLICATION_JSON)
    public CommonResponse getHospitals(@PathParam("searchtxt") String searchtxt) {
        System.out.println("Start getHospitals >> searchtxt = "+searchtxt);
        CommonResponse resp = null;
        
        try {
        	resp = restService.getHospitalsList(searchtxt);
        } catch (RestBusException ex) {
            System.out.println("Exception # getHospitals - "+ex);
        }
        
        System.out.println("<< End getHospitals # "); 
        return resp;
    } 
    
}//End of class
