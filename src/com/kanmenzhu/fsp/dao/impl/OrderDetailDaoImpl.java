package com.kanmenzhu.fsp.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.OrderDetailDao;
import com.kanmenzhu.fsp.entity.LuOrderDetail;

public class OrderDetailDaoImpl extends BaseDaoImpl<LuOrderDetail> implements OrderDetailDao {

	@Override
	public String getEntityName() {
		return "LuOrderDetail";
	}

	@Override
	public List<LuOrderDetail> getOrderDetailByOrderId(Integer orderId) {
		String hql = "from LuOrderDetail d where d.orderId = ?";
		List<LuOrderDetail> list = findByHql(hql, -1, -1, orderId);
		return list;
	}
	
}
