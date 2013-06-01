package com.kanmenzhu.system.security.action;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.web.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends BaseAction {
	
	private DepartmentService departmentService;
	
	private String name;
	private String address;
	private String manager;
	private String phone;
	private String dpid;
	
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
			return SUCC;
		}else {
			logger.info("单位名称或负责人为空！");
			return "regist";
		}
	}
	
	public String update(){
		if (StringUtils.isNotBlank(dpid)) {
			Integer id = Integer.valueOf(dpid);
			LuDepartment department = departmentService.get(id, LuDepartment.class);
			if (StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(manager)) {
				department.setName(name);
				department.setManager(manager);
				department.setAddress(address);
				department.setPhone(phone);
				departmentService.save(department);
				
			}
			return SUCC;
		}else {
			logger.info("单位ID为空！");
			return "list";
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

	public String getDpid() {
		return dpid;
	}

	public void setDpid(String dpid) {
		this.dpid = dpid;
	}
	
	
}
