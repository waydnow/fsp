package com.kanmenzhu.system.security.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.utils.pagination.PageBean;
import com.kanmenzhu.web.BaseAction;

public class DepartmentAction extends BaseAction {
	
	private DepartmentService departmentService;
	
	private LuDepartment department;
	
	private List<LuDepartment> dplist;
	
	private List<LuDepartment> schools;
	
	private Map<String, String> mapType = new HashMap<String, String>();
	
	private Integer id;

	public String regist(){
		logger.info("####添加单位####");
		schools = departmentService.getByType(LuRole.SCHOOL);
		return "regist";
	}
	
	public String add(){
		if(null!=department){
			if (StringUtils.isNotBlank(department.getName())&&StringUtils.isNotBlank(department.getManager())) {
				if(StringUtils.isNotBlank(department.getOpenDepts())){
					String deps = department.getOpenDepts();
					if (deps.endsWith(",")) {
						deps = deps.substring(0, (deps.length()-1));
						department.setOpenDepts(deps);
					}
				}
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
			schools = new ArrayList<LuDepartment>();
			String deps = department.getOpenDepts();
			if (StringUtils.isNotBlank(deps)) {
				String[] dps = deps.split(",");
				for (String d : dps) {
					LuDepartment dp = departmentService.get(Integer.valueOf(d), LuDepartment.class);
					schools.add(dp);
				}
			}
		}
		return "show";
	}
	
	public String update(){
		if (null!=department) {
			if (StringUtils.isNotBlank(department.getName())&&StringUtils.isNotBlank(department.getManager())) {
				if(StringUtils.isNotBlank(department.getOpenDepts())){
					String deps = department.getOpenDepts();
					if (deps.endsWith(",")) {
						deps = deps.substring(0, (deps.length()-1));
						department.setOpenDepts(deps);
					}
				}
				departmentService.update(department);
				return list();
			}
		}
		return list();
	}
	public String delete(){
		if(null!=id){
			LuDepartment ld=departmentService.get(id, LuDepartment.class);
			if(null!=ld){
				departmentService.delete(ld);
				return ajaxResp("0",0);
			}
		}
		return ajaxResp("1",0);
	}
	public String edit(){
		if (null!=department) {
			department = departmentService.get(department.getId(), LuDepartment.class);
			schools = departmentService.getByType(LuRole.SCHOOL);
		}
		return "edit";
	}
	
	public String list(){
		PageBean pb=getPgReq();
		if (department!=null) {
			if (StringUtils.isNotBlank(department.getName())) {
				dplist = departmentService.getByName(pb, department.getName());
				return "list";
			}
		}
		dplist = departmentService.getAll(pb);
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

	public List<LuDepartment> getSchools() {
		return schools;
	}

	public void setSchools(List<LuDepartment> schools) {
		this.schools = schools;
	}

}
