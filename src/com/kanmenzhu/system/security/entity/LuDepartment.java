package com.kanmenzhu.system.security.entity;

import com.kanmenzhu.bean.BaseBean;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

/**
 * LuDepartment generated by hbm2java
 */
public class LuDepartment extends BaseBean {

	private String name;
	private String address;
	private String manager;
	private String phone;

	public LuDepartment() {
	}

	public LuDepartment(String name) {
		this.name = name;
	}

	public LuDepartment(String name, String address, String manager,
			String phone) {
		this.name = name;
		this.address = address;
		this.manager = manager;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}
