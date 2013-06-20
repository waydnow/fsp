package com.kanmenzhu.system.security.dao;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuUser;

public interface UserDao extends BaseDao<LuUser> {

	LuUser findByLoginName(String loginName);
}
