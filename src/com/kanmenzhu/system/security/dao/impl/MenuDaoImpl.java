package com.kanmenzhu.system.security.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.MenuDao;
import com.kanmenzhu.system.security.entity.LuMenu;

public class MenuDaoImpl extends BaseDaoImpl<LuMenu> implements MenuDao {

	@Override
	public String getEntityName() {
		return "LuMenu";
	}

}
