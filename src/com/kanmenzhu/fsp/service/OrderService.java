package com.kanmenzhu.fsp.service;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.service.BaseService;

/**
 * 订单相关的类
 * @author ch_w
 *
 */
public interface OrderService extends BaseService<LuOrder> {

	public List<LuOrder> getOrdersByTime(Date start,Date end);
	
	public List<LuOrder> getOrdersByManager(Date start,Date end);
	
	public List<LuOrder> getOrdersBySupplier(Date start,Date end);
	
	public List<LuOrder> getOrdersByTimeAndStatus(Date start, Date end, String status);
	
}
