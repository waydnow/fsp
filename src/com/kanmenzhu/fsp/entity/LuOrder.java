package com.kanmenzhu.fsp.entity;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.kanmenzhu.bean.BaseBean;

/**
 * 货物表对应的实体
 */
public class LuOrder extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	/**学校订单未提交*/
	public static final int UNSUBMIT_ADUIT = 0;
	/**学校提交订单，文教局审核中*/
	public static final int ADUIT_ING = 1;
	/**文教局审核通过*/
	public static final int ADUIT_SUCCESS = 2;
	/**文教局审核失败*/
	public static final int ADUIT_FAIL = 3;
	/**供应商提交真实订单给学校*/
	public static final int ADUIT_END = 4;
	
	private int deptId;
	private int createUserId;
	private Date createTime;
	private Date submitTime;
	private int status;
	private Integer auditUserId;
	private Date auditTime;
	private String memo;
	private String auditMemo;
	
	

	public LuOrder() {
	}

	public LuOrder(int deptId, int createUserId, Date createTime, int status) {
		this.deptId = deptId;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.status = status;
	}

	public LuOrder(int deptId, int createUserId, Date createTime,
			Date submitTime, int status, Integer auditUserId, Date auditTime,
			String memo, String auditMemo) {
		this.deptId = deptId;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.submitTime = submitTime;
		this.status = status;
		this.auditUserId = auditUserId;
		this.auditTime = auditTime;
		this.memo = memo;
		this.auditMemo = auditMemo;
	}

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getAuditUserId() {
		return this.auditUserId;
	}

	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAuditMemo() {
		return this.auditMemo;
	}

	public void setAuditMemo(String auditMemo) {
		this.auditMemo = auditMemo;
	}

}
