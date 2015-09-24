package com.ixeet.idonyte.persistance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ixeet.idonyte.domain.exception.AppDaoException;
import com.ixeet.idonyte.domain.vo.CommonKeyValueVO;
import com.ixeet.idonyte.domain.vo.HospitalVO;
import com.ixeet.idonyte.persistance.dao.iface.CommonDao;
import com.ixeet.idonyte.persistance.factory.AppDaoAbstract;

public class CommonDaoImpl extends AppDaoAbstract implements CommonDao {

	@Override
	public List<CommonKeyValueVO> getStateList() throws AppDaoException {
		List<CommonKeyValueVO> list = null;
		
		try {
			String query="SELECT STATE_ID,STATE_NM FROM state_mstr order by STATE_NM";
			list=getKeyValuePairList(query);
		} catch (AppDaoException e) {
			e.printStackTrace();
			throw new AppDaoException("getStateList #"+e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<CommonKeyValueVO> getDistrictList(int stateId)
			throws AppDaoException {
		List<CommonKeyValueVO> list = null;
		
		try {
			String query="SELECT DSTRCT_ID,DSTRCT_NM FROM dstrct_mstr where STATE_ID="+stateId+" order by DSTRCT_NM";
			list=getKeyValuePairList(query);
		} catch (AppDaoException e) {
			e.printStackTrace();
			throw new AppDaoException("getDistrictList #"+e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<CommonKeyValueVO> getAreaList(int districtId)
			throws AppDaoException {
		List<CommonKeyValueVO> list = null;
		
		try {
			String query="SELECT AREA_ID,AREA_NM FROM area_mstr where DSTRCT_ID="+districtId+" order by AREA_NM";
			list=getKeyValuePairList(query);
		} catch (AppDaoException e) {
			e.printStackTrace();
			throw new AppDaoException("getAreaList #"+e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<HospitalVO> getHospitalList(String searchtxt)
			throws AppDaoException {
		List<HospitalVO> hospitalList = new ArrayList<HospitalVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HospitalVO vo = null;

		try{
			conn = getConnection();
			String query = "SELECT * FROM hospital_mstr where HOSPITAL_NAME like ? group by STATE,DISTRICT,AREA,HOSPITAL_NAME";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, "%"+searchtxt+"%");
			System.out.println("Query  >>"+query);

			rs = stmt.executeQuery();
			while (rs.next()) {
				vo = new HospitalVO();
				vo.setHospitalId(rs.getInt("HOSPITAL_ID"));
				vo.setHospitalNm(rs.getString("HOSPITAL_NAME"));
				vo.setHospitalAddress1(rs.getString("HOSPITAL_ADDRESS1"));
				vo.setHospitalAddress2(rs.getString("HOSPITAL_ADDRESS2"));
				vo.setArea(rs.getString("AREA"));
				vo.setDistrict(rs.getString("DISTRICT"));
				vo.setState(rs.getString("STATE"));
				vo.setContactNo1(rs.getString("CONTACT_NO1"));
				vo.setContactNo2(rs.getString("CONTACT_NO2"));
				vo.setLat(rs.getString("LAT"));
				vo.setLon(rs.getString("LON"));
				vo.setLastUpdtTm(rs.getString("LAST_UPDT_TM"));

				// Add into list
				hospitalList.add(vo);
			}
			}catch(Exception e){
			System.out.println("error in search hospitals # " + e);
			throw new AppDaoException("search hospitals # "+e.getMessage());
		}finally {
			closeResources(conn, stmt, rs);
		}

		return hospitalList;
	}

}
