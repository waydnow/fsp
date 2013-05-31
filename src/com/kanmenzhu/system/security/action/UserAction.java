package com.kanmenzhu.system.security.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	
	private UserService userService;

	private  LuUser user;
	private String loginName;
	
	private String pwd;
	
	private String verifyCode;
	
	
	public String add(){
		user=userService.get(1, LuUser.class);
		
		return "success";
	}
	
	public String login(){
		user=new LuUser();
		user.setLoginName("myfirst");
		LuUser u=userService.findByLoginName(user.getLoginName());
		logger.info(u.toString());
		return SUCCESS;
	}
	public String welcome(){
		logger.info("#########");
		return "login";
	}
	
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getLoginName() {
		return loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}






	public LuUser getUser() {
		return user;
	}







	public void setUser(LuUser user) {
		this.user = user;
	}
}
