package com.kanmenzhu.system.security.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.web.BaseAction;

public class DepartmentAction extends BaseAction {
	
	private DepartmentService departmentService;
	
	private LuDepartment department;
	
	private List<LuDepartment> dplist;
	
	private Map<String, String> mapType = new HashMap<String, String>();
	
	private Integer id;

	public String regist(){
		logger.info("####添加单位####");
		return "regist";
	}
	
	public String add(){
		if(null!=department){
			if (StringUtils.isNotBlank(department.getName())&&StringUtils.isNotBlank(department.getManager())) {
				departmentService.save(department);
				return list();
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
			if (StringUtils.isNotBlank(department.getName())) {
				departmentService.update(department);
			}
		}
		return list();
	}
	public String delete(){
		if(null!=id){
			LuDepartment ld=departmentService.get(id, LuDepartment.class);
			if(null!=ld){
				departmentService.delete(ld);
			}
		}
		return ajaxResp("0",0);
	}
	public String edit(){
		if (null!=department) {
			department = departmentService.get(department.getId(), LuDepartment.class);
		}
		return "edit";
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
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, String> getMapType() {
		mapType.put(LuRole.MANAGER, "文教局");
		mapType.put(LuRole.SCHOOL, "学校");
		mapType.put(LuRole.SUPPLIER, "供货商");
		return mapType;
	}

	public void setMapType(Map<String, String> mapType) {
		this.mapType = mapType;
	}
	
	
}
