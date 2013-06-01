package com.kanmenzhu.fsp.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.OrderDetailDao;
import com.kanmenzhu.fsp.entity.LuOrderDetail;

public class OrderDetailDaoImpl extends BaseDaoImpl<LuOrderDetail> implements OrderDetailDao {

	@Override
	public String getEntityName() {
		return "LuOrderDetail";
	}
	
}
