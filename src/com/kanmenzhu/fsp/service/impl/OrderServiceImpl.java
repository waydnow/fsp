package com.kanmenzhu.fsp.service.impl;

import java.util.List;

import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderServiceImpl extends BaseServiceImpl<LuOrder> implements OrderService {

	
	@Override
	public List<LuOrder> getOrdersByManager() {
		List<LuOrder> orders  = ((OrderDao)dao).getOrdersByManager();
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersBySupplier() {
		List<LuOrder> orders  = ((OrderDao)dao).getOrdersBySupplier();
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersByTime() {
		// TODO Auto-generated method stub
		return null;
	}



}
