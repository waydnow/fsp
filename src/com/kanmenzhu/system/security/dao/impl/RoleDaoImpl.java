package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.RoleDao;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuRoleUser;

public class RoleDaoImpl extends BaseDaoImpl<LuRole> implements RoleDao {

	@Override
	public String getEntityName() {
		return "LuRole";
	}

	@Override
	public LuRole getRole(LuRoleUser roleUser) {
	
		String hql = "from LuRole r where r.id = ?";
		List<LuRole> roles = getHibernateTemplate().find(hql, roleUser.getRid());
		if (roles!=null) {
			if (roles.size()>1) {
				logger.warn("角色ID="+roleUser.getRid()+"有重复！");
			}
			return roles.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<LuRole> getRoles(List<LuRoleUser> roleUsers) {
		if (roleUsers==null) {
			return null;
		}else {
			String hql = "";
			if (roleUsers.size()>1) {
				String rid = "(";
				for (LuRoleUser ru:roleUsers) {
					rid = rid+ru.getRid()+",";
				}
				rid = rid.substring(0,rid.length()-1);
				rid = rid+")";
				hql = "from LuRole r where r.id in "+rid;
			} else {
				hql = "from LuRole r where r.id ="+roleUsers.get(0).getRid();;
			}
			List<LuRole> roles = getHibernateTemplate().find(hql);
			if (roles!=null) {
				return roles;
			}else {
				return null;
			}
		}
		
	}
	

}
