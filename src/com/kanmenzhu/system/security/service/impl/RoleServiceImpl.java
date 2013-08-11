package com.kanmenzhu.system.security.service.impl;

import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.RoleDao;
import com.kanmenzhu.system.security.dao.RoleUserDao;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.system.security.service.RoleUserService;

public class RoleServiceImpl extends BaseServiceImpl<LuRole> implements RoleService{

	private RoleDao dao;
	private RoleUserDao rudao;
	
	
	@Override
	public List<LuRole> getRoles(LuUser user) {
		dao.getRole();
		return null;
	}

	public RoleDao getDao() {
		return dao;
	}

	public void setDao(RoleDao dao) {
		this.dao = dao;
	}

	public void setRudao(RoleUserDao rudao) {
		this.rudao = rudao;
	}
	
}
