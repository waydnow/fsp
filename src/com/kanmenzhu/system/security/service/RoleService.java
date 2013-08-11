package com.kanmenzhu.system.security.service;

import java.util.List;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuUser;
/**
 * 角色操作相关
 * @author ch_w
 *
 */
public interface RoleService extends BaseService<LuRole> {
	
	public List<LuRole> getRoles(LuUser user);

}
