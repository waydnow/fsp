package com.kanmenzhu.system.security.service.impl;

import com.kanmenzhu.system.security.dao.UserRoleDao;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService {
	private UserRoleDao userRoleDao;

	

	@Override
	public void insert(LuUser u) {
		userRoleDao.save(u);
		
	}
	
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
}
