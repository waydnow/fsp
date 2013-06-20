package com.kanmenzhu.system.security.dao;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuPermission;

public interface PermissionDao extends BaseDao<LuPermission> {

	/**
	 * 保存权限,原有权限将清除,保留新选择的权限
	 * @param rid 角色id
	 * @param menuIds 菜单id们
	 */
	void savePremission(Integer rid,Integer... menuIds);
	
}
