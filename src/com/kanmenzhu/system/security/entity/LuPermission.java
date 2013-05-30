package com.kanmenzhu.system.security.entity;

import com.kanmenzhu.bean.BaseBean;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

/**
 * LuPermission generated by hbm2java
 */
public class LuPermission  extends BaseBean  {

	private Integer id;
	private int menuId;
	private int roleId;

	public LuPermission() {
	}

	public LuPermission(int menuId, int roleId) {
		this.menuId = menuId;
		this.roleId = roleId;
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
