package com.kanmenzhu.system.security.service;

import java.util.List;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.utils.pagination.PageBean;

public interface DepartmentService extends BaseService<LuDepartment> {
	
	/** 根据用户查到用户所属部门  **/
	public LuDepartment getDepartmentByUser(LuUser user);
	
	public List<LuDepartment> getAll();
	
	public List<LuDepartment> getByType(String type);
	
	public List<LuDepartment> getByName(PageBean pb, String name);
	
	public List<LuDepartment> getSupperBySchool(int id);

}
