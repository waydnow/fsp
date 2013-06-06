package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.MenuDao;
import com.kanmenzhu.system.security.entity.LuMenu;

public class MenuDaoImpl extends BaseDaoImpl<LuMenu> implements MenuDao {

	@Override
	public String getEntityName() {
		return "LuMenu";
	}
	

	@Override
	public List<LuMenu> getPermissionByUid(Integer uid, Integer menuParentId) {
		//父级菜单
		String mp=menuParentId==null?"":" and lm.PARENT_id="+menuParentId;
		String sql="select * from LU_MENU lm where exists(select 1 from LU_PERMISSION lp left join " +
				"LU_ROLE_USER lr on lp.ROLE_ID=lr.RID where lr.UID="+uid+" and lm.id=lp.MENU_ID)" +mp+
						" order by lm.ORDER desc";
		return relevanceSqlQuery(sql, LuMenu.class);
	}


	@Override
	public List<LuMenu> getPermissionByRid(Integer rid, Integer menuParentId) {
		//父级菜单
		String mp=menuParentId==null?"":" and lm.PARENT_id="+menuParentId;
		String sql="select * from LU_MENU lm where exists(select 1 from LU_PERMISSION lp where " +
				"lp.ROLE_ID="+rid+" and lm.id=lp.MENU_ID)" +mp+
						" order by lm.ORDER desc";
		return relevanceSqlQuery(sql, LuMenu.class);
	}

}
