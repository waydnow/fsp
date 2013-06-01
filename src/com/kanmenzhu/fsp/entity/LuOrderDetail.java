package com.kanmenzhu.fsp.entity;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.kanmenzhu.bean.BaseBean;

/**
 * 订单详情对应的dao
 */
public class LuOrderDetail extends BaseBean {
	private static final long serialVersionUID = 1L;
	private int goodId;
	private int orderId;
	private Date sendTime;
	private int goodNum;
	private String goodUnit;
	private String memo;

	public LuOrderDetail() {
	}

	public LuOrderDetail(int goodId, int orderId, Date sendTime, int goodNum,
			String goodUnit) {
		this.goodId = goodId;
		this.orderId = orderId;
		this.sendTime = sendTime;
		this.goodNum = goodNum;
		this.goodUnit = goodUnit;
	}

	public LuOrderDetail(int goodId, int orderId, Date sendTime, int goodNum,
			String goodUnit, String memo) {
		this.goodId = goodId;
		this.orderId = orderId;
		this.sendTime = sendTime;
		this.goodNum = goodNum;
		this.goodUnit = goodUnit;
		this.memo = memo;
	}


	public int getGoodId() {
		return this.goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public int getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public String getGoodUnit() {
		return this.goodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		this.goodUnit = goodUnit;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
