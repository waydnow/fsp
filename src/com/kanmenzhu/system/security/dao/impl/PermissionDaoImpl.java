package com.kanmenzhu.system.security.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.entity.LuPermission;

public class PermissionDaoImpl extends BaseDaoImpl<LuPermission> {

	@Override
	public String getEntityName() {
		return "LuPermission";
	}

}
