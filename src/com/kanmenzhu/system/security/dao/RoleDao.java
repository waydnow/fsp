package com.kanmenzhu.system.security.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuRoleUser;
/**
 * 角色操作相关
 * @author ch_w
 *
 */
public interface RoleDao extends BaseDao<LuRole> {
	
	public LuRole getRole(LuRoleUser roleUser);
	
	public List<LuRole> getRoles(List<LuRoleUser> roleUsers);

}
