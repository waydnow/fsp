package com.kanmenzhu.system.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.RoleUserDao;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.RoleUserService;

public class RoleUserServiceImpl extends BaseServiceImpl<LuRoleUser> implements RoleUserService{

	private RoleUserDao dao;
	
	@Override
	public List<LuRoleUser> getRoleByUser(LuUser user) {
		
		List<LuRoleUser> roleUser = dao.getRoleByUser(user);
		List<LuRole> roles = new ArrayList<LuRole>();
		for (LuRoleUser ru:roleUser) {
		}
		
		return roleUser;
	}
	
	

	public RoleUserDao getDao() {
		return dao;
	}

	public void setDao(RoleUserDao dao) {
		this.dao = dao;
	}

}
