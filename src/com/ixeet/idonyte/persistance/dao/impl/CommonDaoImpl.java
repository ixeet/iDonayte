package com.ixeet.idonyte.persistance.dao.impl;

import java.util.List;

import com.ixeet.idonyte.domain.exception.AppDaoException;
import com.ixeet.idonyte.domain.vo.CommonKeyValueVO;
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

}
