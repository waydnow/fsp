package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.UserDao;
import com.kanmenzhu.system.security.entity.LuUser;

public class UserDaoImpl extends BaseDaoImpl<LuUser> implements UserDao {

	@Override
	public LuUser findByLoginName(String loginName) {
		String hql="from LuUser lu where lu.loginName=?";
		List<LuUser> lulist= getHibernateTemplate().find(hql, loginName);
		if(lulist!=null&&lulist.size()>0)
			return (LuUser)lulist.get(0);
		return null;
	}

	@Override
	public String getEntityName() {
		return "LuUser";
	}
	
}
