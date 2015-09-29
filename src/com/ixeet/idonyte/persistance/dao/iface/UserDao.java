package com.ixeet.idonyte.persistance.dao.iface;


import java.util.List;

import com.ixeet.idonyte.domain.exception.AppDaoException;
import com.ixeet.idonyte.domain.vo.UserTO;


public interface UserDao {
	boolean isDonarExist(UserTO user) throws AppDaoException;
	int donarRegistration(UserTO user) throws AppDaoException;
	boolean isReceiverExist(UserTO user) throws AppDaoException;
	int receiverRegistration(UserTO user) throws AppDaoException;

	boolean setUserDonated(int userId) throws AppDaoException;
	boolean setRecieved(int userId) throws AppDaoException;
	boolean setFBId(int userId,String facebookId,String userType) throws AppDaoException;
	UserTO getUser(String contactNo) throws AppDaoException;
	UserTO getDonarUser(String contactNo) throws AppDaoException;
	UserTO getReceiverUser(String contactNo) throws AppDaoException;
	
	List<UserTO> search(String lat,String lon,String searchText,int searchRad,int offset,int noOfRecords) throws AppDaoException;
	List<UserTO> search(String lat,String lon,String searchText,int offset,int noOfRecords) throws AppDaoException;
    
}
