package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.RoleUserDao;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;

public class RoleUserDaoImpl extends BaseDaoImpl<LuRoleUser> implements RoleUserDao{

	@Override
	public List<LuRoleUser> getRoleByUser(LuUser user) {

		String hql = "from LuRoleUser lu where lu.uid = ?";
		List<LuRoleUser> roleUser = getHibernateTemplate().find(hql, user.getId());
		if(roleUser!=null){
			return roleUser;
		}else{
			return null;
		}
		
	}

	@Override
	public String getEntityName() {
		return "LuRoleUser";
	}

}
