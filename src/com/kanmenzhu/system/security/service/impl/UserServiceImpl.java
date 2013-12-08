package com.kanmenzhu.system.security.service.impl;

import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.UserDao;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.utils.pagination.PageBean;

public class UserServiceImpl extends BaseServiceImpl<LuUser> implements UserService{

	@Override
	public LuUser findByLoginName(String loginName) {
		return ((UserDao)dao).findByLoginName(loginName);
	}

	@Override
	public List<LuUser> findByName(String name) {
		return ((UserDao)dao).findByName(name);
	}

	@Override
	public List<LuUser> findByName(String name,PageBean pb ){
		return  ((UserDao)dao).findByName(name,pb);
	}

	@Override
	public List<LuUser> findByHql(String hql, int startRow, int endRow,
			Object... params) {
		return dao.findByHql(hql, startRow, endRow, params);
	}

	@Override
	public List<LuUser> getAll(int startRow, int endRow) {
		return dao.getAll(startRow, endRow);
	}

	
}
