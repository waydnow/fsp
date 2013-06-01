package com.kanmenzhu.fsp.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuOrder;

public class OrderDaoImpl extends BaseDaoImpl<LuOrder> implements OrderDao {

	@Override
	public String getEntityName() {
		return "LuOrder";
	}

}
