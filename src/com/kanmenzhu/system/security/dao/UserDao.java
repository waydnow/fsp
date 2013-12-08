package com.kanmenzhu.system.security.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.utils.pagination.PageBean;

public interface UserDao extends BaseDao<LuUser> {

	LuUser findByLoginName(String loginName);
	/**
	 * 根据姓名查找用户
	 * */
	List<LuUser> findByName(String name);
	/**
	 * 根据姓名查找用户
	 * @param name 用户姓名
	 * @param sr 开始行
	 * @param er 结束行
	 * */
	List<LuUser> findByName(String name,PageBean pb);
}
