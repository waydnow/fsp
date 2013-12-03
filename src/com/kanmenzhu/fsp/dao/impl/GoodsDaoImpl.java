package com.kanmenzhu.fsp.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.GoodsDao;
import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.entity.LuOrder;

public class GoodsDaoImpl extends BaseDaoImpl<LuGoods> implements GoodsDao {

	@Override
	public String getEntityName() {
		return "LuGoods";
	}

	@Override
	public List<LuGoods> getGoodsByTag(int deltag) {
		String hql = "from LuGoods g where g.delTag = ? order by g.createTime desc";
		List<LuGoods> goods = findByHql(hql, -1, -1, deltag);
		return goods;
	}

}
