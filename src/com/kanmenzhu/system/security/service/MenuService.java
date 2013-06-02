package com.kanmenzhu.system.security.service;

import java.util.List;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuMenu;

public interface MenuService extends BaseService<LuMenu> {

	/**
	 * 根据用户id关联角色查询到所有角色能访问到的菜单权限
	 * @param uid
	 * @param menuParentId 父级菜单id，为null/0查询一级主菜单
	 * @return
	 */
	List<LuMenu> getPermissionByUid(Integer uid,Integer menuParentId);
}
