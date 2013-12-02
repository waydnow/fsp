package com.kanmenzhu.system.security.service.impl;

import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.DepartmentDao;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl<LuDepartment> implements DepartmentService{

	
	@Override
	public LuDepartment getDepartmentByUser(LuUser user) {
		LuDepartment department = ((DepartmentDao)dao).getDepartmentByUser(user);
		return department;
	}

	@Override
	public List<LuDepartment> getAll() {
		List<LuDepartment> departments = ((DepartmentDao)dao).getAll(-1,-1);
		return departments;
	}

	@Override
	public List<LuDepartment> getByType(String type) {
		List<LuDepartment> departments = ((DepartmentDao)dao).getByType(type);
		return departments;
	}

	
}
