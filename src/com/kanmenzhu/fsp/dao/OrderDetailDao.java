package com.kanmenzhu.fsp.dao;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.fsp.entity.LuOrderDetail;

/**
 * 订单详情dao
 * @author ch_w 2013-6-1
 *
 */
public interface OrderDetailDao extends BaseDao<LuOrderDetail> {

	List<LuOrderDetail> getOrderDetailByOrderId(Integer orderId);

	List<LuOrderDetail> getOrderDetailsByTimeAndStatus(Date start, Date end, String status);

	/**
	 * 获取订单详细，条件：时间、学校、状态
	 * @param start
	 * @param end
	 * @param status
	 * @param deptId
	 * @return
	 */
	List<LuOrderDetail> getOrderDetailsByTimeStatusType(Date start, Date end,
			String status, int deptId);

}
