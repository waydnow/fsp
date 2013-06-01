package com.kanmenzhu.system.security.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	private String verifyCode;
	
	private UserService userService;
	private DepartmentService departmentService;

	private LuUser user;
	private List<LuDepartment> dps;
	
	
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
		logger.info("####进入登录页面#####");
		return "login";
	}
	
	public String regist(){
		dps = departmentService.getAll();
		return "regist";
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

	public UserService getUserService() {
		return userService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public List<LuDepartment> getDps() {
		return dps;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDps(List<LuDepartment> dps) {
		this.dps = dps;
	}
	
	
}
