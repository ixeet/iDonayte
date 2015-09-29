/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.constants;

/**
 *
 * @author dell
 */
public class AppRestConstants {
	
    public static final int status_failure=1000;
    public static final String message_failure="failure";
    public static final int status_success=1001;
    public static final String message_success="success";
    public static final int status_noUpdate=1002;
    public static final String message_noUpdate="Sorry!!! No record updated. Please try again";
    public static final int status_userExist=1006;
    public static final String message_userExist="Sorry!!! this contact number is already regsitered with us";
    public static final int status_userNotExist=1007;
    public static final String message_userNotExist="Sorry!!! this contact number does not exist.";
    public static final int status_wrongcredential=1008;
    public static final String message_wrongcredential="Sorry!!! Userid or Password seems to be incorrect. Please try again";
    public static final int status_badrequest=1009;
    public static final String message_badrequest="Bad request";
    public static final int status_fieldRequired=1010;
    public static final String message_fieldRequired="Sorry!!! Incorrect input";
    public static final String message_recordnotfound="Sorry!!! No record found";
    public static final String message_noOfRecordsRequired="No of matched records should be > 0.";
    
    //Error messages......
    
    public static final String message_FirstNameRequired="Please provide your First Name";
    public static final String message_LastNameRequired="Please provide your Last Name";
    public static final String message_UserIdRequired="UserId is Required";
    public static final String message_GenderRequired="Please select your Gender";
    public static final String message_DateOfBirthRequired="Please select your Date Of Birth";
    public static final String message_ContactRequired="Please provide your Contact Number";
    public static final String message_EmailRequired="Please provide Email Id ";
    public static final String message_BloodGroupIdRequired="Please select your Blood Group";
    public static final String message_DonateTypeIdRequired="Donate Type Id is Required";
    public static final String message_FacebookIdRequired="Facebook Id is Required";
    public static final String message_AddressRequired="Please provide your Address ";
    public static final String message_AreaRequired="Please select your Locality";
    public static final String message_DistrictRequired="Please select your District/City";
    public static final String message_StateRequired="Please select your State";
    public static final String message_latRequired="Sorry!!! Latitude missing";
    public static final String message_lonRequired="Sorry!!! Longitude missing";
    public static final String message_EmailDispFlagRequired="Email Display Flag is Required";
    public static final String message_ContactDispFlagRequired="ContactDispFlag is Required";
    public static final String message_StateIdRequired="StateId is Required";

    
    
}
