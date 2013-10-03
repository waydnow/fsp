package com.kanmenzhu.system.security.service;

import java.util.List;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuUser;


public interface UserService extends BaseService<LuUser>{
	/**
	 * 根据登录名查找用户
	 * */
	LuUser findByLoginName(String loginName);
	/**
	 * 根据姓名查找用户
	 * */
	List<LuUser> findByName(String name);
	
}
