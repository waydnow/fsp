package com.kanmenzhu.system.security.action;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	
	private Logger logger=LoggerFactory.getLogger(getClass());

	private DepartmentService departmentService;
	
	private LuDepartment department;
	
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
	
	
}
