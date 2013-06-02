package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.PermissionDao;
import com.kanmenzhu.system.security.entity.LuMenu;
import com.kanmenzhu.system.security.entity.LuPermission;

public class PermissionDaoImpl extends BaseDaoImpl<LuPermission> implements PermissionDao{

	@Override
	public String getEntityName() {
		return "LuPermission";
	}
}
