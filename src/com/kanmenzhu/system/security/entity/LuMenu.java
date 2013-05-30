package com.kanmenzhu.system.security.entity;

import com.kanmenzhu.bean.BaseBean;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

/**
 * LuMenu generated by hbm2java
 */
public class LuMenu  extends BaseBean  {

	private String name;
	private String link;
	private Integer parentId;
	private Integer isdisplay;

	public LuMenu() {
	}

	public LuMenu(String name) {
		this.name = name;
	}

	public LuMenu(String name, String link, Integer parentId, Integer isdisplay) {
		this.name = name;
		this.link = link;
		this.parentId = parentId;
		this.isdisplay = isdisplay;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getIsdisplay() {
		return this.isdisplay;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}

}
