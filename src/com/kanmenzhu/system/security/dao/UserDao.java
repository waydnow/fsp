package com.kanmenzhu.system.security.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuUser;

public interface UserDao extends BaseDao<LuUser> {

	LuUser findByLoginName(String loginName);
	/**
	 * 根据姓名查找用户
	 * */
	List<LuUser> findByName(String name);
}
