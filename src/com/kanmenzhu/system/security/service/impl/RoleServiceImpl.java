package com.kanmenzhu.system.security.service.impl;

import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.RoleDao;
import com.kanmenzhu.system.security.dao.RoleUserDao;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.system.security.service.RoleUserService;

public class RoleServiceImpl extends BaseServiceImpl<LuRole> implements RoleService{

	private RoleUserDao rudao;
	
	
	@Override
	public List<LuRole> getRoles(LuUser user) {
		List<LuRoleUser> roleUser = rudao.getRoleByUser(user);
		List<LuRole> roles = ((RoleDao)dao).getRoles(roleUser);
		return roles;
	}

	public void setRudao(RoleUserDao rudao) {
		this.rudao = rudao;
	}
	
}
