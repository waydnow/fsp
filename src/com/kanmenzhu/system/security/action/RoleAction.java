package com.kanmenzhu.system.security.action;

import java.util.List;

import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.system.security.service.RoleUserService;
import com.kanmenzhu.utils.pagination.PageBean;
import com.kanmenzhu.web.BaseAction;

public class RoleAction extends BaseAction{
	
	private RoleUserService ruService;
	
	private RoleService roleService;
	
	private List<LuRole> rolelist;
	
	private LuRole role;
	
	public String regist(){
		
		//TODO 判断用户角色是否权限创建角色
		
		return "regist";
	}
	
	public String add(){
		if (null!=role) {
			//TODO 查询是否已添加相同角色  LuRole oldRole = ruService.
			ruService.save(role);
		}
		return list();
	}
	
	public String list(){
		PageBean pb=getPgReq();
		rolelist = roleService.getAll(pb);
		return "list";
	}
	
	public String show(){
		if (null!=role) {
			if (null!=role.getId()) {
				role = roleService.get(role.getId(), LuRole.class);
			}
		}
		return "show";
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

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<LuRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<LuRole> rolelist) {
		this.rolelist = rolelist;
	}
	

}
