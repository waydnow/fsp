package com.kanmenzhu.system.security.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;

public interface DepartmentDao extends BaseDao<LuDepartment> {
	
	public LuDepartment getDepartmentByUser(LuUser user);

	public List<LuDepartment> getByType(String type);

}
