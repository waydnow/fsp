package com.kanmenzhu.system.security.service.impl;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.PermissionDao;
import com.kanmenzhu.system.security.entity.LuPermission;
import com.kanmenzhu.system.security.service.PermissionService;

public class PermissionServiceImpl extends BaseServiceImpl<LuPermission> implements PermissionService{

	@Override
	public void savePremission(Integer rid, String... menuIds) {
		Integer[] mids=new Integer[menuIds.length];
		for(int i=0;i<menuIds.length;i++){
			mids[i]=Integer.valueOf(menuIds[i]);
		}
		((PermissionDao)dao).savePremission(rid, mids);
	}

}
