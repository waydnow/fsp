package com.kanmenzhu.fsp.entity;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import com.kanmenzhu.bean.BaseBean;

/**
 * 订单详情对应的dao
 */
public class LuOrderDetail extends BaseBean {
	private static final long serialVersionUID = 1L;
	/**订单id*/
	private int goodId;
	private String goodName;
	private int orderId;
	private Date sendTime;
	private String send;
	private int goodNum;
	private String goodUnit;
	private String memo;
	private int status;
	private int parentId;
	private int userId;
	private int deptId;
	private Date createTime;
	private String depName;
	private String price;
	private BigDecimal orderPrice;
	private String orderUnit;

	public LuOrderDetail() {
	}

	public LuOrderDetail(int goodId, int orderId, Date sendTime, int goodNum,
			String goodUnit, String memo, int status, int parentId, int userId, Date createTime) {
		this.goodId = goodId;
		this.orderId = orderId;
		this.sendTime = sendTime;
		this.goodNum = goodNum;
		this.goodUnit = goodUnit;
		this.memo = memo;
		this.status = status;
		this.parentId = parentId;
		this.userId = userId;
		this.createTime = createTime;
	}
	
	public String toString() {
		return "订单"+this.orderId+"详细，物品："+this.goodName+"，数量："+this.goodNum+"，单价："+this.orderPrice+"，单位："+this.orderUnit
				+",送货时间："+this.sendTime;
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

	public int getStatus() {
		return status;
	}

	public int getParentId() {
		return parentId;
	}

	public int getUserId() {
		return userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

}
