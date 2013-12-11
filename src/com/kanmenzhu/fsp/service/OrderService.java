package com.kanmenzhu.fsp.service;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.utils.pagination.PageBean;

/**
 * 订单相关的类
 * @author ch_w
 *
 */
public interface OrderService extends BaseService<LuOrder> {

	public List<LuOrder> getOrdersByTime(PageBean pb, Date start,Date end);
	
	public List<LuOrder> getOrdersByManager(PageBean pb, Date start,Date end);
	
	public List<LuOrder> getOrdersBySupplier(PageBean pb, Date start,Date end);
	
	public List<LuOrder> getOrdersByTimeAndStatus(PageBean pb, Date start, Date end, String status);
	
}
