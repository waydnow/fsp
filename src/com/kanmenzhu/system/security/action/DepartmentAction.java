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
	
	private String name;
	private String address;
	private String manager;
	private String phone;
	
	public String regist(){
		logger.info("####添加单位####");
		return "regist";
	}
	
	public String add(){
		LuDepartment department = new LuDepartment();
		if (StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(manager)) {
			department.setName(name);
			department.setManager(manager);
			department.setAddress(address);
			department.setPhone(phone);
			departmentService.save(department);
			return "success";
		}else {
			logger.info("单位名称或负责人为空！");
			return "regist";
		}
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getManager() {
		return manager;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
}
