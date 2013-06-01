package com.kanmenzhu.system.security.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.web.BaseAction;

public class DepartmentAction extends BaseAction {
	
	private DepartmentService departmentService;
	
	private LuDepartment department;
	
	private List<LuDepartment> dplist;
	
	public String regist(){
		logger.info("####添加单位####");
		return "regist";
	}
	
	public String add(){
		if(null!=department){
			if (StringUtils.isNotBlank(department.getName())&&StringUtils.isNotBlank(department.getName())) {
				departmentService.save(department);
				return "success";
			}
		}
		logger.info("单位名称或负责人为空！");
		return "regist";
	}
	
	public String show(){
		if (null!=department) {
			department = departmentService.get(department.getId(), LuDepartment.class);
		}
		return "show";
	}
	
	public String update(){
		if (null!=department) {
			departmentService.update(department);
		}
		return "list";
	}
	
	public String list(){
		dplist = departmentService.getAll(-1, -1);
		return "list";
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public LuDepartment getDepartment() {
		return department;
	}

	public void setDepartment(LuDepartment department) {
		this.department = department;
	}

	public List<LuDepartment> getDplist() {
		return dplist;
	}

	public void setDplist(List<LuDepartment> dplist) {
		this.dplist = dplist;
	}
	
	
}
