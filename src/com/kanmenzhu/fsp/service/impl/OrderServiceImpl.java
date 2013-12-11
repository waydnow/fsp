package com.kanmenzhu.fsp.service.impl;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.utils.pagination.PageBean;

public class OrderServiceImpl extends BaseServiceImpl<LuOrder> implements OrderService {

	
	@Override
	public List<LuOrder> getOrdersByManager(PageBean pb, Date start,Date end) {
		List<LuOrder> orders  = ((OrderDao)dao).getOrdersByManager(pb,start,end);
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersBySupplier(PageBean pb, Date start,Date end) {
		List<LuOrder> orders  = ((OrderDao)dao).getOrdersBySupplier(pb,start,end);
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersByTimeAndStatus(PageBean pb, Date start, Date end, String status) {
		return null;
	}

	@Override
	public List<LuOrder> getOrdersByTime(PageBean pb, Date start, Date end) {
		List<LuOrder> orders  = ((OrderDao)dao).getOrdersByTime(pb,start, end);
		return orders;
	}



}
