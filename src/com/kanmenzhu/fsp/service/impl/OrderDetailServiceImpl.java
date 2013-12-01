package com.kanmenzhu.fsp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.dao.OrderDetailDao;
import com.kanmenzhu.fsp.entity.LuOrderDetail;
import com.kanmenzhu.fsp.service.OrderDetailService;
import com.kanmenzhu.service.impl.BaseServiceImpl;

public class OrderDetailServiceImpl extends BaseServiceImpl<LuOrderDetail> implements OrderDetailService {

	
	@Override
	public List<LuOrderDetail> getOrderDetailByOrderId(Integer orderId) {
		List<LuOrderDetail> orderDetailList = new ArrayList<LuOrderDetail>();
		orderDetailList = ((OrderDetailDao)dao).getOrderDetailByOrderId(orderId);
		return orderDetailList;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByTimeAndStatus(Date start, Date end, String status) {
		List<LuOrderDetail> orderDetailList = ((OrderDetailDao)dao).getOrderDetailsByTimeAndStatus(start, end, status);
		return orderDetailList;
	}
	
}
