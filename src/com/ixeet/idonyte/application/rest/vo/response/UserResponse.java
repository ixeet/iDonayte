/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.application.rest.vo.response;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ixeet.idonyte.domain.vo.UserTO;

/**
 *
 * @author dell
 */

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserResponse extends CommonRespTO{
    private String userId;
    private String userName;
    private UserTO userDetail;
    private List<UserTO> usersList;
    private List<StateRespTO> stateList;
    private String userType;
    
    
    
    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<StateRespTO> getStateList() {
		return stateList;
	}

	public void setStateList(List<StateRespTO> stateList) {
		this.stateList = stateList;
	}

	public List<UserTO> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserTO> usersList) {
		this.usersList = usersList;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserTO getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserTO userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "UserResponse{" + "userId=" + userId + ", userName=" + userName + ", userDetail=" + userDetail + '}';
    }
    
        
    
}
