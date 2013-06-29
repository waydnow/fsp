package com.kanmenzhu.fsp.service;

import java.util.List;

import com.kanmenzhu.fsp.entity.LuOrderDetail;
import com.kanmenzhu.service.BaseService;

/**
 * 订单详情相关service
 * @author ch_w 2013-6-1
 *
 */
public interface OrderDetailService extends BaseService<LuOrderDetail> {

	public List<LuOrderDetail> getOrderDetailByOrderId(Integer orderId);
	
}
