package com.kanmenzhu.system.security.service.impl;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.UserDao;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<LuUser> implements UserService{

	@Override
	public LuUser findByLoginName(String loginName) {
		return ((UserDao)dao).findByLoginName(loginName);
	}
}
