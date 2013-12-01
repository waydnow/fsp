package com.kanmenzhu.fsp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.OrderDetailDao;
import com.kanmenzhu.fsp.entity.LuOrderDetail;

public class OrderDetailDaoImpl extends BaseDaoImpl<LuOrderDetail> implements OrderDetailDao {

	@Override
	public String getEntityName() {
		return "LuOrderDetail";
	}

	@Override
	public List<LuOrderDetail> getOrderDetailByOrderId(Integer orderId) {
		String hql = "from LuOrderDetail d where d.orderId = ?";
		List<LuOrderDetail> list = findByHql(hql, -1, -1, orderId);
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByTimeAndStatus(Date start, Date end, String status) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.sendTime between ? and ? and d.status=? order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start,end,s);
		}else {
			hql = "from LuOrderDetail d where d.sendTime between ? and ? order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start,end);
		}
		return list;
	}
	
}
