package com.kanmenzhu.fsp.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.entity.LuOrderDetail;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.fsp.service.OrderDetailService;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.web.BaseAction;

public class OrderAction extends BaseAction {
	
	private LuOrder order;
	
	private List<LuOrder> orderList;
	private List<LuOrderDetail> odetailList;
	private List<LuGoods> goodsList;
	private Map<Integer, LuDepartment> goodDept;
	private Map<Integer,LuGoods> goodMap;
	
	private OrderService orderService;
	private OrderDetailService odetailService;
	private DepartmentService departmentService;
	private GoodsService goodsService;
	
	public String regist(){
		order = null;
		goodsList = goodsService.getAll(-1, -1);
		odetailList = new ArrayList<LuOrderDetail>();
		LuOrderDetail detail = new LuOrderDetail();
		odetailList.add(detail);		
		for (LuGoods good : goodsList) {
			LuDepartment department = departmentService.get(good.getDeptId(), LuDepartment.class);
//			goodDept.put(good.getId(), department);
//			goodMap.put(good.getId(), good);
		}
		logger.info("####订单页面####");
		return "regist";
	}
	
	public String add(){
		
		if (null!=order) {
			order.setCreateTime(new Date());
			//创建用户
			LuUser user = getCurrentUser();
			order.setCreateUserId(user.getId());
			order.setDeptId(user.getDeptId());
			order.setStatus(ADUIT);
			orderService.save(order);
		}
		return list();
	}

	public String list(){
		orderList = orderService.getAll(-1, -1);
		return "list";
	}
	
	public LuOrder getOrder() {
		return order;
	}

	public List<LuOrder> getOrderList() {
		return orderList;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrder(LuOrder order) {
		this.order = order;
	}

	public void setOrderList(List<LuOrder> orderList) {
		this.orderList = orderList;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<LuOrderDetail> getOdetailList() {
		return odetailList;
	}

	public OrderDetailService getOdetailService() {
		return odetailService;
	}

	public void setOdetailList(List<LuOrderDetail> odetailList) {
		this.odetailList = odetailList;
	}

	public void setOdetailService(OrderDetailService odetailService) {
		this.odetailService = odetailService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public List<LuGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<LuGoods> goodsList) {
		this.goodsList = goodsList;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Map<Integer, LuDepartment> getGoodDept() {
		return goodDept;
	}

	public void setGoodDept(Map<Integer, LuDepartment> goodDept) {
		this.goodDept = goodDept;
	}

	public Map<Integer, LuGoods> getGoodMap() {
		return goodMap;
	}

	public void setGoodMap(Map<Integer, LuGoods> goodMap) {
		this.goodMap = goodMap;
	}
	
}
