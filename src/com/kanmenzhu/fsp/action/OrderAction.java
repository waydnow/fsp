package com.kanmenzhu.fsp.action;

import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.entity.LuOrderDetail;
import com.kanmenzhu.fsp.service.OrderDetailService;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.web.BaseAction;

public class OrderAction extends BaseAction {
	
	private LuOrder order;
	
	private List<LuOrder> orderList;
	private List<LuOrderDetail> odetailList;
	
	private OrderService orderService;
	private OrderDetailService odetailService;
	private DepartmentService departmentService;
	
	public String regist(){
		order = null;
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
	
}
