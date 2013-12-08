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
		String hql = "from LuOrderDetail d where d.orderId = ? and d.status != 99";
		List<LuOrderDetail> list = findByHql(hql, -1, -1, orderId);
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByTimeStatusType(Date start, Date end, String status, int deptId) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.deptId=? and d.sendTime between ? and ? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,start,end,s);
		}else {
			hql = "from LuOrderDetail d where d.deptId=? and d.sendTime between ? and ? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,start,end);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByTimeAndStatus(Date start, Date end, String status) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.sendTime between ? and ? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start,end,s);
		}else {
			hql = "from LuOrderDetail d where d.sendTime between ? and ? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start,end);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByStatusType(String status, int deptId) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.deptId=? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,s);
		}else {
			hql = "from LuOrderDetail d where d.deptId=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByStartStatusType(Date start,	String status, int deptId) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.deptId=? and d.status!=99 and d.sendTime >= ? order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,start,s);
		}else {
			hql = "from LuOrderDetail d where d.deptId=? and d.status!=99 and d.sendTime >= ? order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,start);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByEndStatusType(Date end,	String status, int deptId) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.deptId=? and d.sendTime <= ? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,end,s);
		}else {
			hql = "from LuOrderDetail d where d.deptId=? and d.sendTime <= ? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, deptId,end);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByEndAndStatus(Date end, String status) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.sendTime <= ? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, end,s);
		}else {
			hql = "from LuOrderDetail d where d.sendTime <= ? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, end);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByStartAndStatus(Date start, String status) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.sendTime >= ? and d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start,s);
		}else {
			hql = "from LuOrderDetail d where d.sendTime >= ? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, start);
		}
		return list;
	}

	@Override
	public List<LuOrderDetail> getOrderDetailsByStatus(String status) {
		String hql = "";
		List<LuOrderDetail> list = new ArrayList<LuOrderDetail>();
		if (StringUtils.isNotBlank(status)) {
			int s = Integer.parseInt(status);
			hql = "from LuOrderDetail d where d.status=? and d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1, s);
		}else {
			hql = "from LuOrderDetail d where d.status!=99 order by d.sendTime asc";
			list = findByHql(hql, -1, -1);
		}
		return list;
	}
	
}
