package com.kanmenzhu.system.security.service;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuPermission;

public interface PermissionService extends BaseService<LuPermission> {
	/**
	 * 保存权限,原有权限将清除,保留新选择的权限
	 * @param rid 角色id
	 * @param menuIds 菜单id们
	 */
	void savePremission(Integer rid,String... menuIds);
}
