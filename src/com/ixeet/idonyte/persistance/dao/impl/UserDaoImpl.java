package com.ixeet.idonyte.persistance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ixeet.idonyte.domain.constants.AppConstants;
import com.ixeet.idonyte.domain.exception.AppDaoException;
import com.ixeet.idonyte.persistance.dao.iface.UserDao;
import com.ixeet.idonyte.persistance.factory.AppDaoAbstract;
import com.ixeet.idonyte.domain.vo.UserTO;

public class UserDaoImpl extends AppDaoAbstract implements UserDao {
	

	public int donarRegistration(UserTO user) throws AppDaoException {
		System.out.println("Inside donarRegistration>>>>");

		int count = 0;

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet resultSet = null;

		try {
			conn = this.getConnection(dataSource);

			String query = "INSERT INTO user_donor_mstr(FNAME, LNAME, GENDER, DOB, BLOOD_GP_ID, DONATE_TYP_ID, CONTACT_NO, CONTACT_DISP_FL, EMAIL, EMAIL_DISP_FL, FB_ID, ISDONATED, LAST_DONATED_DT, LAST_UPDT_TM)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?, current_timestamp)";
			cstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getGender());
			cstmt.setString(4, user.getDateOfBirth());
			cstmt.setInt(5, user.getBloodGroupId());
			cstmt.setInt(6, user.getDonateTypeId());
			cstmt.setString(7, user.getContactNo());
			cstmt.setString(8, user.getContactNoDispFlag());
			cstmt.setString(9, user.getEmail());
			cstmt.setString(10, user.getEmailDispFlag());
			cstmt.setString(11, user.getFacebookId());
			cstmt.setString(12, user.getIsDonated());
			cstmt.setString(13, user.getLastDonatedDate());
	
			
			count = cstmt.executeUpdate();
			System.out.println("No of affected row = " + count);
            resultSet = cstmt.getGeneratedKeys();
            if (resultSet.next()) {
            int last_inserted_id = resultSet.getInt(1);
                System.out.println("Last inserted userId : "+last_inserted_id);
                String userType=AppConstants.USER_TYPE_DONOR;
                
                //Save address
                String query_add="INSERT INTO address(ADDRESS1, ADDRESS2, AREA, DISTRICT, STATE, LAT, LON, USRID, USER_TYPE)VALUES('"+user.getAddress1()+"', '"+user.getAddress2()+"', '"+user.getArea()+"', '"+user.getDistrict()+"', '"+user.getState()+"', '"+user.getLat()+"', '"+user.getLon()+"', "+last_inserted_id+", '"+userType+"')";
                System.out.println("Save address query : "+query_add);
                deleteOrUpdateByQuery(query_add);
            }			
			
		} catch (Exception e) {
			System.out.println("Error donar Registration - " + e.getMessage());
			throw new AppDaoException("Donar registration - "+e.getMessage());
		} finally {
			closeResources(conn, cstmt, resultSet);
		}

		return count;
	}
	

	public int receiverRegistration(UserTO user) throws AppDaoException {
		System.out.println("Inside receiverRegistration>>>>");

		int count = 0;

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet resultSet = null;

		try {
			conn = this.getConnection(dataSource);

			String query = "INSERT INTO user_recepient_mstr(FNAME, LNAME, CONTACT_NO, BLOOD_GP_ID, DONATE_TYP_ID, RELATION, FB_ID, ISRECEIVED, LAST_UPDT_TM)VALUES(?, ?, ?, ?, ?, ?, null, '0', current_timestamp)";
			cstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getContactNo());
			cstmt.setInt(4, user.getBloodGroupId());
			cstmt.setInt(5, user.getDonateTypeId());
			cstmt.setString(6, user.getRelation());

			count = cstmt.executeUpdate();
			System.out.println("No of affected row = " + count);
            resultSet = cstmt.getGeneratedKeys();
            if (resultSet.next()) {
            int last_inserted_id = resultSet.getInt(1);
                System.out.println("Last inserted userId : "+last_inserted_id);
                String userType=AppConstants.USER_TYPE_RECEIVER;
               
                //Save address
                String query_add="INSERT INTO address(ADDRESS1, ADDRESS2, AREA, DISTRICT, STATE, LAT, LON, USRID, USER_TYPE)VALUES('"+user.getAddress1()+"', '"+user.getAddress2()+"', '"+user.getArea()+"', '"+user.getDistrict()+"', '"+user.getState()+"', '"+user.getLat()+"', '"+user.getLon()+"', "+last_inserted_id+", '"+userType+"')";
                System.out.println("Save address query : "+query_add);
                deleteOrUpdateByQuery(query_add);
            }	
            
		} catch (Exception e) {
			System.out.println("Error receiver Registration - "
					+ e.getMessage());
			throw new AppDaoException(e.getMessage());
		} finally {
			closeResources(conn, cstmt, resultSet);
		}

		return count;
	}

	
	
	public boolean isDonarExist(UserTO user) throws AppDaoException {
		System.out.println("Inside isDonarExist>>>>");

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet rs = null;

		boolean status = false;

		try {
			conn = this.getConnection(dataSource);

			String query = "SELECT USRID FROM user_donor_mstr where FNAME = ? AND LNAME = ? AND CONTACT_NO = ?";
			cstmt = conn.prepareStatement(query);
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getContactNo());

			rs = cstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Records exists in the row" + status);
				status=true;
			}

		} catch (Exception e) {
			System.out.println("Error Donar Exist - " + e.getMessage());
			throw new AppDaoException(e.getMessage());
		} finally {
			closeResources(conn, cstmt, rs);
		}

		return status;
	}

	
	public boolean isReceiverExist(UserTO user) throws AppDaoException {
		System.out.println("Inside isReceiverExist>>>>");

		Connection conn = null;
		PreparedStatement cstmt = null;
		ResultSet rs = null;

		boolean status = false;

		try {
			conn = this.getConnection(dataSource);

			String query = "SELECT USRID FROM user_recepient_mstr where FNAME = ? AND LNAME = ? AND CONTACT_NO = ?";
			cstmt = conn.prepareStatement(query);
			cstmt.setString(1, user.getFirstName());
			cstmt.setString(2, user.getLastName());
			cstmt.setString(3, user.getContactNo());

			rs = cstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Records exists in the row" + status);
				status=true;
			}
			
		} catch (Exception e) {
			System.out.println("Error Receiver Exist - " + e.getMessage());
			throw new AppDaoException(e.getMessage());
		} finally {
			closeResources(conn, cstmt, rs);
		}

		return status;
	}
	

    @Override
    public boolean setUserDonated(int userId) throws AppDaoException {
               
               Connection conn = null;
               PreparedStatement cstmt = null;
               ResultSet resultSet = null;

               boolean status = false;

               try {
                   conn = this.getConnection(dataSource);
 
                   String query="UPDATE user_donor_mstr SET ISDONATED=1, LAST_UPDT_TM= current_timestamp WHERE USRID=?";
                   cstmt = conn.prepareStatement(query);
                   cstmt.setInt(1, userId);
                   System.out.println("Inserted ISDONOR in DONOR Records");
                   int count=cstmt.executeUpdate();
                if(count>0)
                {
                  status = true;
                }else{
                  status = false;
                }
                   System.out.println("No of affected row = "+count);
               } catch (Exception e) {
                   System.out.println("Error setUserDonated - "+e.getMessage());
               } finally {
                   closeResources(conn, cstmt, resultSet);
               }

           return status;
    }
    

    @Override
    public boolean setRecieved(int userId) throws AppDaoException {
        Connection conn = null;
        PreparedStatement cstmt = null;
        ResultSet resultSet = null;

        boolean status = true;

        try {
            conn = this.getConnection(dataSource);

            String query="UPDATE user_recepient_mstr SET ISRECEIVED=1, LAST_UPDT_TM= current_timestamp WHERE USRID=?";
            cstmt = conn.prepareStatement(query);
            cstmt.setInt(1, userId);
            System.out.println("Inserted ISRECEIVED in RECEIVER Records");
            int count=cstmt.executeUpdate();
         if(count>0)
         {
           status = true;
         }else{
           status = false;
         }
            System.out.println("No of affected row = "+count);
        } catch (Exception e) {
            System.out.println("Error receiver setRecieved - "+e.getMessage());
        } finally {
            closeResources(conn, cstmt, resultSet);
        }

    return status;
    }


    @Override
    public boolean setFBId(int userId, String facebookId, String userType) throws AppDaoException {
        Connection conn = null;
        PreparedStatement cstmt = null;
        ResultSet resultSet = null;
           boolean status = true;

        try {
            conn = this.getConnection(dataSource);
            String query=null;
            if(userType == AppConstants.USER_TYPE_DONOR)
            {
                  query="UPDATE user_donor_mstr SET FB_ID=?, LAST_UPDT_TM= current_timestamp WHERE USRID=?";

            }
            else if(userType == AppConstants.USER_TYPE_RECEIVER)
            {
                 query="UPDATE user_recepient_mstr SET FB_ID=?, LAST_UPDT_TM= current_timestamp WHERE USRID=?";
            }
            
            cstmt = conn.prepareStatement(query);
            cstmt.setString(1, facebookId);
            cstmt.setInt(2, userId);

            System.out.println("updated fbId in user Records");
            int count=cstmt.executeUpdate();
         if(count>0)
         {
           status = true;
         }else{
           status = false;
         }
            System.out.println("No of affected row = "+count);
        } catch (Exception e) {
            System.out.println("Error set fbId  - "+e.getMessage());
           throw new AppDaoException(e.getMessage()); 
        } finally {
            closeResources(conn, cstmt, resultSet);
        }

    return status;
    }


    
	@Override
	public UserTO getUser(String contactNo) throws AppDaoException {
		UserTO user=null;
		
		String quesryChkUserAvailability = "select temp.userType from(SELECT USRID,'D' as userType,LAST_UPDT_TM FROM user_donor_mstr where CONTACT_NO='"+contactNo+"' union SELECT USRID,'R' as userType,LAST_UPDT_TM FROM user_recepient_mstr where CONTACT_NO='"+contactNo+"')temp order by temp.LAST_UPDT_TM desc limit 1";
		String userType=getQueryConcatedResult(quesryChkUserAvailability);
		
		if(userType.equalsIgnoreCase(AppConstants.USER_TYPE_DONOR))
		{
			user=getDonarUser(contactNo);
			user.setUserType(AppConstants.USER_TYPE_DONOR);
		}
		else if(userType.equalsIgnoreCase(AppConstants.USER_TYPE_RECEIVER))
		{
			user=getReceiverUser(contactNo);
			user.setUserType(AppConstants.USER_TYPE_RECEIVER);
		}
		else
		{
			user=new UserTO();
			user.setUserType(AppConstants.USER_TYPE_NONE);
		}
		
		return user;
	}

	
	@Override
	public UserTO getDonarUser(String contactNo) throws AppDaoException {

		UserTO user=null;
		
        Connection conn = null;
        PreparedStatement cstmt = null;
        ResultSet resultSet = null;

        try {
            String query="SELECT donor.USRID,donor.FNAME,donor.LNAME,donor.GENDER,donor.DOB,donor.BLOOD_GP_ID,donor.DONATE_TYP_ID,donor.CONTACT_NO,donor.CONTACT_DISP_FL,donor.EMAIL,donor.EMAIL_DISP_FL,donor.FB_ID,donor.ISDONATED,donor.LAST_DONATED_DT,address.ADDRESS1,address.ADDRESS2,address.AREA,address.DISTRICT,address.STATE,address.LAT,address.LON,address.USRID,address.USER_TYPE FROM user_donor_mstr donor inner join address address on address.USRID=donor.USRID where upper(address.USER_TYPE)='D' and donor.CONTACT_NO=?";
            System.out.println("Query : " + query);

            conn = this.getConnection(dataSource);
            cstmt = conn.prepareStatement(query);
            cstmt.setString(1, contactNo);
            
            resultSet = cstmt.executeQuery();
            if(resultSet.next())
            {
            user=new UserTO();
        	user.setUserId(resultSet.getInt(1));
        	user.setFirstName(resultSet.getString(2));
        	user.setLastName(resultSet.getString(3));
        	user.setGender(resultSet.getString(4));
        	user.setDateOfBirth(resultSet.getString(5));
        	user.setBloodGroupId(resultSet.getInt(6));    	
        	user.setDonateTypeId(resultSet.getInt(7));
        	user.setContactNo(resultSet.getString(8));
        	user.setContactNoDispFlag(resultSet.getString(9));
        	user.setEmail(resultSet.getString(10));
        	user.setEmailDispFlag(resultSet.getString(11));
        	user.setFacebookId(resultSet.getString(12));
        	user.setIsDonated(resultSet.getString(13));
        	user.setLastDonatedDate(resultSet.getString(14));

        	user.setAddress1(resultSet.getString(15));
        	user.setAddress2(resultSet.getString(16));
        	user.setArea(resultSet.getString(17));
        	user.setDistrict(resultSet.getString(18));
        	user.setState(resultSet.getString(19));
        	user.setLat(resultSet.getString(20));
        	user.setLon(resultSet.getString(21));
            }
            
        } catch (Exception e) {
            System.out.println("Error > getDonarUser - "+e.getMessage());
            throw new AppDaoException("getDonarUser # "+e.getMessage());
        } finally {
            closeResources(conn, cstmt, resultSet);
        }


		return user;
	}

	@Override
	public UserTO getReceiverUser(String contactNo) throws AppDaoException {

		UserTO user=null;
		
        Connection conn = null;
        PreparedStatement cstmt = null;
        ResultSet resultSet = null;

        try {
            String query="SELECT usr.USRID,usr.FNAME,usr.LNAME,usr.CONTACT_NO,usr.BLOOD_GP_ID,usr.DONATE_TYP_ID,usr.RELATION,usr.FB_ID,usr.ISRECEIVED,adrs.ADDRESS1,adrs.ADDRESS2,adrs.AREA,adrs.DISTRICT,adrs.STATE,adrs.LAT,adrs.LON  FROM user_recepient_mstr usr inner join address adrs on usr.USRID=adrs.USRID and upper(adrs.USER_TYPE)='R' where usr.CONTACT_NO=?";
            System.out.println("Query : " + query);

            conn = this.getConnection(dataSource);
            cstmt = conn.prepareStatement(query);
            cstmt.setString(1, contactNo);
            
            resultSet = cstmt.executeQuery();
            if(resultSet.next())
            {
            user=new UserTO();
        	user.setUserId(resultSet.getInt(1));
        	user.setFirstName(resultSet.getString(2));
        	user.setLastName(resultSet.getString(3));
        	user.setContactNo(resultSet.getString(4));
        	user.setBloodGroupId(resultSet.getInt(5));    	
        	user.setDonateTypeId(resultSet.getInt(6));
        	user.setRelation(resultSet.getString(7));
        	user.setFacebookId(resultSet.getString(8));
        	user.setIsReceived(resultSet.getString(9));

        	user.setAddress1(resultSet.getString(10));
        	user.setAddress2(resultSet.getString(11));
        	user.setArea(resultSet.getString(12));
        	user.setDistrict(resultSet.getString(13));
        	user.setState(resultSet.getString(14));
        	user.setLat(resultSet.getString(15));
        	user.setLon(resultSet.getString(16));
            }
            
        } catch (Exception e) {
            System.out.println("Error > getReceiverUser - "+e.getMessage());
            throw new AppDaoException("getReceiverUser # "+e.getMessage());
        } finally {
            closeResources(conn, cstmt, resultSet);
        }


		return user;
	}

	
	
	@Override
	public List<UserTO> search(String lat, String lon, String searchText,
			int offset, int noOfRecords) throws AppDaoException {
		List<UserTO> searchList = new ArrayList<UserTO>();

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			//SELECT * FROM(SELECT *,(((acos(sin((28.573430*pi()/180)) * sin((LAT*pi()/180))+cos((28.573430*pi()/180)) * cos((LAT*pi()/180)) * cos(((77.317110 - LON)*pi()/180))))*180/pi())*60*1.1515*1.609344) as distance FROM address) t WHERE distance <= 8
			
			String sql = "SELECT donor.USRID,donor.FNAME,donor.LNAME,donor.GENDER,donor.CONTACT_NO,donor.BLOOD_GP_ID,temp.ADDRESS1,temp.AREA,temp.DISTRICT,temp.STATE FROM(SELECT *,(((acos(sin((?*pi()/180)) * sin((LAT*pi()/180))+cos((?*pi()/180)) * cos((LAT*pi()/180)) * cos(((? - LON)*pi()/180))))*180/pi())*60*1.1515*1.609344) as distance FROM address) temp inner join user_donor_mstr donor on donor.USRID=temp.USRID inner join blood_grp_mstr bgm on bgm.BLOOD_GRP_ID=donor.BLOOD_GP_ID WHERE temp.distance <= 10 and bgm.BLOOD_GRP_TXT like ? limit ?,?";
			System.out.println("Search Sql Query - "+sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lat);
			stmt.setString(2, lat);
			stmt.setString(3, lon);
			stmt.setString(4, "%"+searchText+"%");
			stmt.setInt(5, offset);
			stmt.setInt(6, noOfRecords);

			ResultSet rs = stmt.executeQuery();
			UserTO user = null;
			while (rs.next()) {
				user = new UserTO();
				user.setUserId(rs.getInt(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setContactNo(rs.getString(5));
				user.setBloodGroupId(rs.getInt(6));
				user.setAddress1(rs.getString(7));
				user.setArea(rs.getString(8));
				user.setDistrict(rs.getString(9));
				user.setState(rs.getString(10));
				// Add into list
				searchList.add(user);
			}

		} catch (Exception e) {
			System.out.println("error in search # " + e);
			throw new AppDaoException("search # "+e.getMessage());
		} finally {
			closeResources(conn, stmt, null);
		}

		return searchList;
	}
	
	

	public static void main(String args[]) throws AppDaoException {

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserTO user = new UserTO();
		user.setFirstName("XYZ1");
		user.setLastName("abc");
		user.setContactNo("9876543131");
		// user.setEmail("xyz@abc.com");
		// user.setBloodGroup("O");
		// user.setRelation("Mom");
		// userDaoImpl.donarRegistration(user);
		// userDaoImpl.receiverRegistration(user);
		// userDaoImpl.isDonarExist(user);
		userDaoImpl.isReceiverExist(user);
	}

}// End of class
