package com.kanmenzhu.fsp.entity;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import com.kanmenzhu.bean.BaseBean;

/**
 * LU_GOODS表对应的实体类
 */
public class LuGoods extends BaseBean {
	private static final long serialVersionUID = 1L;
	private int deptId;
	private String name;
	private String unit;
	private BigDecimal price;
	private int createUserId;
	private Date createTime;
	private String memo;
	private String deptName;
	private int delTag;
	public static final int OK = 0;
	public static final int DELETE = 1;

	public LuGoods() {
	}

	public LuGoods(int deptId, String name, int createUserId, Date createTime) {
		this.deptId = deptId;
		this.name = name;
		this.createUserId = createUserId;
		this.createTime = createTime;
	}

	public LuGoods(int deptId, String name, String unit, BigDecimal price,
			int createUserId, Date createTime, String memo) {
		this.deptId = deptId;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.memo = memo;
	}

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDelTag() {
		return delTag;
	}

	public void setDelTag(int delTag) {
		this.delTag = delTag;
	}

}
