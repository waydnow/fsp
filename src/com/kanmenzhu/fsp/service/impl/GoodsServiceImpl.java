package com.kanmenzhu.fsp.service.impl;

import java.util.List;

import com.kanmenzhu.fsp.dao.GoodsDao;
import com.kanmenzhu.fsp.dao.OrderDao;
import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.utils.pagination.PageBean;

public class GoodsServiceImpl extends BaseServiceImpl<LuGoods> implements	GoodsService {

	@Override
	public List<LuGoods> getGoodsByTag(PageBean pb, int deltag) {
		List<LuGoods> goods  = ((GoodsDao)dao).getGoodsByTag(pb,deltag);
		return goods;
	}

	@Override
	public List<LuGoods> getGoodsByTag(int ok) {
		List<LuGoods> goods  = ((GoodsDao)dao).getGoodsByTag(ok);
		return goods;
	}
}
