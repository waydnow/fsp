package com.kanmenzhu.fsp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.GoodsDao;
import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.utils.pagination.PageBean;

public class GoodsDaoImpl extends BaseDaoImpl<LuGoods> implements GoodsDao {

	@Override
	public String getEntityName() {
		return "LuGoods";
	}

	@Override
	public List<LuGoods> getGoodsByTag(PageBean pb, int deltag) {
		String hql = "from LuGoods g where g.delTag = ? order by g.createTime desc";
		List<LuGoods> goods = findByHql(hql, pb, deltag);
		return goods;
	}

	@Override
	public List<LuGoods> getGoodsByTag(int ok) {
		String hql = "from LuGoods g where g.delTag = ? order by g.name,g.createTime desc";
		List<LuGoods> goods = findByHql(hql,-1,-1, ok);
		return goods;
	}

	@Override
	public List<LuGoods> getGoodsByTagAndDept(int ok, int id) {
		String hql = "from LuGoods g where g.delTag = ? and g.deptId =? order by g.name,g.createTime desc";
		List<LuGoods> goods = new ArrayList<LuGoods>();
		goods = findByHql(hql,-1,-1,ok,id);
		return goods;
	}

}
