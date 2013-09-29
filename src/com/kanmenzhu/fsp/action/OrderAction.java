package com.kanmenzhu.fsp.action;

import java.text.SimpleDateFormat;
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
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.web.BaseAction;

public class OrderAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LuOrder order;
	
	private List<LuOrder> orderList;
	private List<LuOrderDetail> odetailList;
	private List<LuGoods> goodsList;
	private List<LuRole> roleList;
	private Map<Integer, LuDepartment> goodDept;
	private Map<Integer,LuGoods> goodMap;
	
	private OrderService orderService;
	private OrderDetailService odetailService;
	private DepartmentService departmentService;
	private GoodsService goodsService;
	private RoleService roleService;
	
	public String regist(){
		order = null;
		roleList = roleService.getRoles(getCurrentUser());
		goodsList = goodsService.getAll(-1, -1);
		odetailList = new ArrayList<LuOrderDetail>();
		LuOrderDetail detail = new LuOrderDetail();
		odetailList.add(detail);		
		logger.info("####订单页面####");
		return "regist";
	}
	
	public String add(){
		if(order != null){
			order.setCreateTime(new Date());
			order.setCreateUserId(getCurrentUser().getId());
			order.setDeptId(getCurrentUser().getDeptId());
			order.setStatus(LuOrder.UNSUBMIT_ADUIT);
			orderService.save(order);
			if (odetailList!=null) {
				for (LuOrderDetail orderDetail : odetailList) {
					if (null!=orderDetail) {
						orderDetail.setCreateTime(new Date());
						orderDetail.setOrderId(order.getId());
						orderDetail.setStatus(LuOrder.UNSUBMIT_ADUIT);
						orderDetail.setUserId(getCurrentUser().getId());
						odetailService.save(orderDetail);
					}
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"创建订单ID="+order.getId());
		}else {
			logger.error("保存订单时，订单为NULL，操作人："+getCurrentUser().getLoginName());
		}		
		return list();
	}
	
	public String addAudit(){
		if(order != null){
			order.setCreateTime(new Date());
			order.setCreateUserId(getCurrentUser().getId());
			order.setDeptId(getCurrentUser().getDeptId());
			order.setStatus(LuOrder.ADUIT_ING);
			order.setSubmitTime(new Date());
			orderService.save(order);
			if (odetailList!=null) {
				for (LuOrderDetail orderDetail : odetailList) {
					if (null!=orderDetail) {
						orderDetail.setCreateTime(new Date());
						orderDetail.setOrderId(order.getId());
						orderDetail.setStatus(LuOrder.ADUIT_ING);
						orderDetail.setUserId(getCurrentUser().getId());
						odetailService.save(orderDetail);
					}
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"创建并送审订单ID="+order.getId());
		}else {
			logger.error("保存订单时，订单为NULL，操作人："+getCurrentUser().getLoginName());
		}		
		return list();
	}

	public String list(){
		//根据用户权限获取订单
		roleList = roleService.getRoles(getCurrentUser());
		if (roleList!=null) {
			for (LuRole role : roleList) {
				if (LuRole.SCHOOL.equals(role.getType())) {
					//学校可查询所有状态订单
					orderList = orderService.getAll(-1, -1);
					return "list";
				}else if (LuRole.MANAGER.equals(role.getType())) {
					orderList = orderService.getOrdersByManager();
					//文教局可查询审核中及审核通过及审核未通过的订单
				}else if (LuRole.SUPPLIER.equals(role.getType())) {
					//供应商可查询审核通过的订单
					orderList = orderService.getOrdersBySupplier();
				}
			}
		}
		return "list";
	}
	
	public String show() throws Exception{
		roleList = roleService.getRoles(getCurrentUser());
		goodsList = goodsService.getAll(-1, -1);
		if (order!=null) {
			order = orderService.get(order.getId(), LuOrder.class);
			odetailList = odetailService.getOrderDetailByOrderId(order.getId());
			for (LuOrderDetail detail : odetailList) {
				Date send = detail.getSendTime();
				System.out.println("时间"+send.toString());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(send);
				detail.setSend(time);
			}
		}
		return "show";
	}
	
	public String delete(){
		if (order!=null) {
			order = orderService.get(order.getId(), LuOrder.class);
			odetailList = odetailService.getOrderDetailByOrderId(order.getId());
			for (LuOrderDetail detail : odetailList) {
				odetailService.delete(detail);
			}
			orderService.delete(order);
			logger.info("用户"+getCurrentUser().getLoginName()+"将订单ID="+order.getId()+"删除！");
		}
		return list();
	}
	
	public String update(){
		if (order!=null) {
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				if (null == detail.getId()) {
					detail.setCreateTime(new Date());
					detail.setOrderId(order.getId());
					detail.setUserId(getCurrentUser().getId());
					odetailService.save(detail);
				}else {
					odetailService.update(detail);
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"更新订单ID="+order.getId());
		}
		return "show";
	}
	
	public String audit(){
		if (order!=null) {
			order.setSubmitTime(new Date());
			order.setStatus(LuOrder.ADUIT_ING);
			orderService.update(order);
			logger.info("用户"+getCurrentUser().getLoginName()+"送审订单ID="+order.getId());
		}
		return list();
	}
	
	public String updateAudit(){
		if (order!=null) {
			order.setSubmitTime(new Date());
			order.setStatus(LuOrder.ADUIT_ING);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				if (null == detail.getId()) {
					detail.setCreateTime(new Date());
					detail.setOrderId(order.getId());
					detail.setStatus(LuOrder.ADUIT_ING);
					detail.setUserId(getCurrentUser().getId());
					odetailService.save(detail);
				}else {
					odetailService.update(detail);
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"更新并送审订单ID="+order.getId());
		}
		return "show";
	}
	
	public String auditPass(){
		if (order!=null) {
			order.setAuditTime(new Date());
			order.setStatus(LuOrder.ADUIT_SUCCESS);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				detail.setStatus(LuOrder.ADUIT_SUCCESS);
				odetailService.update(detail);
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"审核订单ID="+order.getId()+"通过!");
		}
		return list();
	}
	
	public String auditNoPass(){
		if (order!=null) {
			order.setAuditTime(new Date());
			order.setStatus(LuOrder.ADUIT_FAIL);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				detail.setStatus(LuOrder.ADUIT_FAIL);
				odetailService.update(detail);
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"审核订单ID="+order.getId()+"不通过，返回提交用户!");
		}
		return list();
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

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<LuRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<LuRole> roleList) {
		this.roleList = roleList;
	}
	
	
	
}
