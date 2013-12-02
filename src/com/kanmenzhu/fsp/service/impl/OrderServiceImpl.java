package com.kanmenzhu.fsp.service.impl;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.service.impl.BaseServiceImpl;

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
	public List<LuOrder> getOrdersByTimeAndStatus(Date start, Date end, String status) {
		return null;
	}



}
