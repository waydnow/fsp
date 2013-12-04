package com.kanmenzhu.fsp.dao;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.fsp.entity.LuOrder;

/**
 * 订单相关dao
 * @author ch_w 2013-6-1
 *
 */
public interface OrderDao extends BaseDao<LuOrder> {

	public List<LuOrder> getOrdersByManager(Date start,Date end);
	
	public List<LuOrder> getOrdersBySupplier(Date start,Date end);
	
	public List<LuOrder> getOrdersByTime(Date start,Date end);
	
}
