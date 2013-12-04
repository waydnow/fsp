package com.kanmenzhu.fsp.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuOrder;

public class OrderDaoImpl extends BaseDaoImpl<LuOrder> implements OrderDao {

	@Override
	public String getEntityName() {
		return "LuOrder";
	}
	
	@Override
	public List<LuOrder> getOrdersByManager(Date start,Date end) {
		String hql = "from LuOrder d where d.status != ?";
		List<LuOrder> orders = new ArrayList<LuOrder>();
		if (start!=null&&end!=null) {
			hql = hql+" and d.createTime between ? and ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1, LuOrder.UNSUBMIT_ADUIT,start,end);
		}
		if (start!=null&&end==null) {
			hql = hql+" and d.createTime >= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1, LuOrder.UNSUBMIT_ADUIT,start);
		}
		if (start==null&&end!=null) {
			hql = hql+" and d.createTime <= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1, LuOrder.UNSUBMIT_ADUIT,end);
		}
		if (start==null&&end==null) {
			hql = hql+" order by d.createTime desc";
			orders = findByHql(hql, -1, -1, LuOrder.UNSUBMIT_ADUIT);
		}
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersBySupplier(Date start,Date end) {
		String hql = "from LuOrder d where d.status in ("+LuOrder.ADUIT_END+","+LuOrder.ADUIT_SUCCESS+")";
		List<LuOrder> orders = new ArrayList<LuOrder>();
		if (start!=null&&end!=null) {
			hql = hql+" and d.createTime between ? and ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,start,end);
		}
		if (start!=null&&end==null) {
			hql = hql+" and d.createTime >= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,start);
		}
		if (start==null&&end!=null) {
			hql = hql+" and d.createTime <= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,end);
		}
		if (start==null&&end==null) {
			hql = hql+" order by d.createTime desc";
			orders = findByHql(hql, -1, -1);
		}
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersByTime(Date start, Date end) {
		String hql = "from LuOrder d ";
		List<LuOrder> orders = new ArrayList<LuOrder>();
		if (start!=null&&end!=null) {
			hql = hql+" where d.createTime between ? and ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,start,end);
		}
		if (start!=null&&end==null) {
			hql = hql+" where d.createTime >= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,start);
		}
		if (start==null&&end!=null) {
			hql = hql+" where d.createTime <= ? order by d.createTime desc";
			orders = findByHql(hql, -1, -1,end);
		}
		if (start==null&&end==null) {
			hql = hql+" order by d.createTime desc";
			orders = findByHql(hql, -1, -1);
		}
		return orders;
	}

}
