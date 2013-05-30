package com.kanmenzhu.system.security.entity;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * LuLogs generated by hbm2java
 */
public class LuLogs implements java.io.Serializable {

	private Integer id;
	private Integer objId;
	private int operUserId;
	private int type;
	private String operIp;
	private Date operTime;
	private String operDesc;

	public LuLogs() {
	}

	public LuLogs(int operUserId, int type, Date operTime) {
		this.operUserId = operUserId;
		this.type = type;
		this.operTime = operTime;
	}

	public LuLogs(Integer objId, int operUserId, int type, String operIp,
			Date operTime, String operDesc) {
		this.objId = objId;
		this.operUserId = operUserId;
		this.type = type;
		this.operIp = operIp;
		this.operTime = operTime;
		this.operDesc = operDesc;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getObjId() {
		return this.objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	public int getOperUserId() {
		return this.operUserId;
	}

	public void setOperUserId(int operUserId) {
		this.operUserId = operUserId;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getOperIp() {
		return this.operIp;
	}

	public void setOperIp(String operIp) {
		this.operIp = operIp;
	}

	public Date getOperTime() {
		return this.operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public String getOperDesc() {
		return this.operDesc;
	}

	public void setOperDesc(String operDesc) {
		this.operDesc = operDesc;
	}

}