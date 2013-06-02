package com.kanmenzhu.system.security.service.impl;

import java.util.List;

import com.kanmenzhu.service.impl.BaseServiceImpl;
import com.kanmenzhu.system.security.dao.MenuDao;
import com.kanmenzhu.system.security.entity.LuMenu;
import com.kanmenzhu.system.security.service.MenuService;

public class MenuServiceImpl extends BaseServiceImpl<LuMenu> implements MenuService{
	@Override
	public List<LuMenu> getPermissionByUid(Integer uid,Integer menuParentId) {
		// TODO Auto-generated method stub
		return ((MenuDao)dao).getPermissionByUid(uid, menuParentId);
	}
	
}
