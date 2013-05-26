package com.kanmenzhu.test.web;

import com.kanmenzhu.system.security.entity.User;
import com.kanmenzhu.system.security.service.UserRoleService;
import com.kanmenzhu.web.BaseAction;

public class MyTest extends BaseAction{
	private UserRoleService urService;
	
	public String execute(){
		logger.info("进入了本方法");
		User u=new User();
		u.setDec("dec");
		u.setMemo("m");
		u.setName("name");
		u.setId(2134l);
		urService.insert(u);
		return "success";
	}
	public MyTest(){
		logger.info("------------");
	}
	
	
	public void setUrService(UserRoleService urService) {
		this.urService = urService;
	}
}
