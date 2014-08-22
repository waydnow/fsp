package com.kanmenzhu.fsp.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.utils.pagination.PageBean;
import com.kanmenzhu.web.BaseAction;

public class GoodsAction extends BaseAction {
	
	private GoodsService goodsService;
	private DepartmentService departmentService;
	private RoleService roleService;
	
	private LuGoods goods;
	private String goodid;
	
	private List<LuGoods> goodsList;
	private List<LuDepartment> depList;
	
	public String regist(){
		deptList();
		goods = null;
		logger.info("####添加物品####");
		return "regist";
	}
	
	public String add(){
		if (null!=goods) {
			if (null!=goods.getName()) {
				goods.setCreateTime(new Date());
				goods.setCreateUserId(getCurrentUser().getId());
				goods.setDeptId(goods.getDeptId());
				logger.info("用户"+getCurrentUser().getLoginName()+"创建物品"+goods.toString());
				goodsService.save(goods);
				logger.info("保存成功！用户："+getCurrentUser().getLoginName()+"，物品："+goods.toString());
			}
		}
		return list();
	}
	
	public String update(){
		if (null!=goods) {
			if (null!=goods.getName()) {
				logger.info("用户"+getCurrentUser().getLoginName()+"修改物品"+goods.toString());
				goodsService.update(goods);
				logger.info("用户"+getCurrentUser().getLoginName()+"修改完成物品"+goods.toString());
			}
		}
		return list();
	}
	
	public String show(){
		deptList();
		if (null!=goods) {
			if (null!=goods.getId()) {
				goods = goodsService.get(goods.getId(), LuGoods.class);
			}
		}
		return "show";
	}
	
	public String edit(){
		deptList();
		if (null!=goods) {
			if (null!=goods.getId()) {
				goods = goodsService.get(goods.getId(), LuGoods.class);
			}
		}
		return "edit";
	}
	
	public String list(){
		PageBean pb = getPgReq();
		goodsList = goodsService.getGoodsByTag(pb,LuGoods.OK);
		for (LuGoods gd : goodsList) {
			LuDepartment dp = departmentService.get(gd.getDeptId(), LuDepartment.class);
			if (dp==null) {
				gd.setDeptName("供应商被删除");
			}else {
				gd.setDeptName(dp.getName());
			}
		}
		return "list";
	}
	
    public void deptList(){
    	//判断当前用户是否为文教部门
    	depList = new ArrayList<LuDepartment>();
		List<LuRole> roles = roleService.getRoles(getCurrentUser());
		boolean isTrue = false;
		for (LuRole role:roles) {
			if (LuRole.MANAGER.equals(role.getType())) {
				isTrue = true;
			}
		}
		if (isTrue) {
			depList = departmentService.getByType(LuRole.SUPPLIER);		
		}else {
			LuDepartment dep = departmentService.getDepartmentByUser(getCurrentUser());
			if (null!=dep) {
				depList.add(dep);
			}
		}				
    }
    
    public String delete(){
    	if(null!=goods){
    		if (goods.getId()!=null) {
    			LuGoods ld=goodsService.get(goods.getId(), LuGoods.class);
    			ld.setDelTag(LuGoods.DELETE);
    			goodsService.update(ld);
			}
		}
		return ajaxResp("0",0);
    }
	
	public String getdep(){
		if (!goodid.equals("undefined")) {
			Integer id = Integer.valueOf(goodid);
			LuGoods good = goodsService.get(id, LuGoods.class);
			LuDepartment dep = departmentService.get(good.getDeptId(), LuDepartment.class);
			String depname = "供应商被删除";
			if (dep!=null) {
				depname = dep.getName();
			}
			String data = "{\"factory\":\""+good.getFactory()+"\",\"standard\":\""+good.getStandard()+"\",\"name\":\""+depname+"\",\"unit\":\""+good.getUnit()+"\",\"price\":\""+good.getPrice()+"\"}";
			logger.debug(good.getName()+"="+data);
			return ajaxResp(data,1);
		}
		return ajaxResp("undefined",0);
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

	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<LuDepartment> getDepList() {
		return depList;
	}

	public void setDepList(List<LuDepartment> depList) {
		this.depList = depList;
	}

	public List<String> getUnitList() {
		return Arrays.asList(unitList);
	}
	
}
