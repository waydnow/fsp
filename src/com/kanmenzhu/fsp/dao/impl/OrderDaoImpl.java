package com.kanmenzhu.fsp.dao.impl;

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
	public List<LuOrder> getOrdersByManager() {
		String hql = "from LuOrder d where d.status in (1,2,3,4)";
		List<LuOrder> orders = getHibernateTemplate().find(hql);
		return orders;
	}

	@Override
	public List<LuOrder> getOrdersBySupplier() {
		String hql = "from LuOrder d where d.status in (2,4)";
		List<LuOrder> orders = getHibernateTemplate().find(hql);
		return orders;
	}

}
