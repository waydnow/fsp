package com.kanmenzhu.system.security.action;

import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;

public class UserAction extends BaseAction {
	private UserService userService;

	private  LuUser user;
	
	public String add(){
		user=(LuUser)userService.get(1, LuUser.class);
		
		return "success";
	}
	
	public String login(){
		
		return "success";
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}







	public LuUser getUser() {
		return user;
	}







	public void setUser(LuUser user) {
		this.user = user;
	}
}
