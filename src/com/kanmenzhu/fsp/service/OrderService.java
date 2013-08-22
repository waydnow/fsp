package com.kanmenzhu.fsp.service;

import java.util.List;

import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.service.BaseService;

/**
 * 订单相关的类
 * @author ch_w
 *
 */
public interface OrderService extends BaseService<LuOrder> {

	public List<LuOrder> getOrdersByManager();
	
	public List<LuOrder> getOrdersBySupplier();
	
}
