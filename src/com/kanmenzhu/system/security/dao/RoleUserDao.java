package com.kanmenzhu.system.security.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;

public interface RoleUserDao extends BaseDao<LuRoleUser> {
	
	public List<LuRoleUser> getRoleByUser(LuUser user);

}
