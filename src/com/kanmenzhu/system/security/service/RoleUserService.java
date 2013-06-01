package com.kanmenzhu.system.security.service;

import java.util.List;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;

public interface RoleUserService extends BaseService<LuRoleUser>{
	
	
	/**
	 * 根据用户获取用户角色
	 * @return
	 */
	public List<LuRoleUser> getRoleByUser(LuUser user);

}
