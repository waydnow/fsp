package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.UserDao;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.utils.pagination.PageBean;

public class UserDaoImpl extends BaseDaoImpl<LuUser> implements UserDao {

	@Override
	public LuUser findByLoginName(String loginName) {
		String hql="from LuUser lu where lu.loginName=? and lu.deltag=0";
		List<LuUser> lulist= findByHql(hql, -1, -1,loginName);
		if(lulist!=null&&lulist.size()>0)
			return (LuUser)lulist.get(0);
		return null;
	}

	@Override
	public String getEntityName() {
		return "LuUser";
	}

	@Override
	public List<LuUser> findByName(String name) {
		String hql="from LuUser lu where lu.name =? and lu.deltag=0"; 
		List<LuUser> lulist= findByHql(hql, -1, -1,name);
		return lulist;
	}

	@Override
	public List<LuUser> findByName(String name, PageBean pb) {
		String hql="from LuUser lu where lu.name =? and lu.deltag=0";
		List<LuUser> lulist= findByHql(hql,pb,name);
		return lulist;
	}
	
}
