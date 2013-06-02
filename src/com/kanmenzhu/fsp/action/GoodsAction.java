package com.kanmenzhu.fsp.action;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.web.BaseAction;

public class GoodsAction extends BaseAction {
	
	private GoodsService goodsService;
	
	private LuGoods goods;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public LuGoods getGoods() {
		return goods;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setGoods(LuGoods goods) {
		this.goods = goods;
	}
	
	
	

}
