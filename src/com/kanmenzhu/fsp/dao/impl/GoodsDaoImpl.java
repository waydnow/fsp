package com.kanmenzhu.fsp.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.fsp.dao.GoodsDao;
import com.kanmenzhu.fsp.entity.LuGoods;

public class GoodsDaoImpl extends BaseDaoImpl<LuGoods> implements GoodsDao {

	@Override
	public String getEntityName() {
		return "LuGoods";
	}

}
