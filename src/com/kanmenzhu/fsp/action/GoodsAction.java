package com.kanmenzhu.fsp.action;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;

public class GoodsAction extends BaseAction {
	
	private GoodsService goodsService;
	private DepartmentService departmentService;
	
	private LuGoods goods;
	
	private List<LuGoods> goodsList;
	
	public String regist(){
		goods = null;
		logger.info("####添加物品####");
		return "regist";
	}
	
	public String add(){
		if (null!=goods) {
			if (null!=goods.getName()) {
				goods.setCreateTime(new Date());
				//暂时取一个用户  
				goods.setCreateUserId(2);
				goods.setDeptId(4);
				goodsService.save(goods);
			}
		}
		return list();
	}
	
	public String list(){
		goodsList = goodsService.getAll(-1, -1);
		for (LuGoods gd : goodsList) {
			LuDepartment dp = departmentService.get(gd.getDeptId(), LuDepartment.class);
			gd.setDeptName(dp.getName());
		}
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

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	
}
