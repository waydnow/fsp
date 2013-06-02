package com.kanmenzhu.system.security.action;

import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.RoleUserService;

public class RoleAction {
	
	private RoleUserService ruService;
	
	private LuRole role;
	
	public String regist(){
		
		//TODO 判断用户角色是否权限创建角色
		
		
		return "regist";
	}
	
	

	public RoleUserService getRuService() {
		return ruService;
	}

	public LuRole getRole() {
		return role;
	}

	public void setRuService(RoleUserService ruService) {
		this.ruService = ruService;
	}

	public void setRole(LuRole role) {
		this.role = role;
	}
	

}
