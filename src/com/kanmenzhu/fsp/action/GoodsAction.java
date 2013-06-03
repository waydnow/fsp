package com.kanmenzhu.fsp.action;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.web.BaseAction;

public class GoodsAction extends BaseAction {
	
	private GoodsService goodsService;
	
	private LuGoods goods;
	
	private List<LuGoods> goodsList;
	
	public String regist(){
		logger.info("####添加物品####");
		return "regist";
	}
	
	public String add(){
		if (null!=goods) {
			if (null!=goods.getName()) {
				goods.setCreateTime(new Date());
				goods.setCreateUserId(getCurrentUser().getId());
				goods.setDeptId(getCurrentUser().getDeptId());
				goodsService.save(goods);
			}
		}
		return list();
	}
	
	public String list(){
		goodsList = goodsService.getAll(-1, -1);
		return "list";
	}

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

	public List<LuGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<LuGoods> goodsList) {
		this.goodsList = goodsList;
	}
	
}
