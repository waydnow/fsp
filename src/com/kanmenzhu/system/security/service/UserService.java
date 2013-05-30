package com.kanmenzhu.system.security.service;

import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.system.security.entity.LuUser;


public interface UserService extends BaseService<LuUser>{
	/**
	 * 根据登录名查找用户
	 * */
	LuUser findByLoginName(String loginName);
	
}
