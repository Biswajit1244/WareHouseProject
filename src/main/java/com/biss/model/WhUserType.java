package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WH_USER_GEN")
	@SequenceGenerator(name="WH_USER_GEN", sequenceName = "whuser_id",allocationSize = 1)
	@Column(name="userid")
	private Integer userId;
	@Column(name="user_type")
	private String whUserType;
	@Column(name="usercode")
	private String whUserCode;
	@Column(name="user_for")
	private String whUserFor;
	@Column(name="email")
	private String whUserEmail;
	@Column(name="contact")
	private String whUserCont;
	@Column(name="id_type")
	private String whUserIdType;
	@Column(name="other_idtype")
	private String whUserIdOther;
	@Column(name="id_num")
	private String whUserIdNum;
	public WhUserType() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getWhUserType() {
		return whUserType;
	}
	public void setWhUserType(String whUserType) {
		this.whUserType = whUserType;
	}
	public String getWhUserCode() {
		return whUserCode;
	}
	public void setWhUserCode(String whUserCode) {
		this.whUserCode = whUserCode;
	}
	public String getWhUserFor() {
		return whUserFor;
	}
	public void setWhUserFor(String whUserFor) {
		this.whUserFor = whUserFor;
	}
	public String getWhUserEmail() {
		return whUserEmail;
	}
	public void setWhUserEmail(String whUserEmail) {
		this.whUserEmail = whUserEmail;
	}
	public String getWhUserCont() {
		return whUserCont;
	}
	public void setWhUserCont(String whUserCont) {
		this.whUserCont = whUserCont;
	}
	public String getWhUserIdType() {
		return whUserIdType;
	}
	public void setWhUserIdType(String whUserIdType) {
		this.whUserIdType = whUserIdType;
	}
	public String getWhUserIdOther() {
		return whUserIdOther;
	}
	public void setWhUserIdOther(String whUserIdOther) {
		this.whUserIdOther = whUserIdOther;
	}
	public String getWhUserIdNum() {
		return whUserIdNum;
	}
	public void setWhUserIdNum(String whUserIdNum) {
		this.whUserIdNum = whUserIdNum;
	}
	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", whUserType=" + whUserType + ", whUserCode=" + whUserCode
				+ ", whUserFor=" + whUserFor + ", whUserEmail=" + whUserEmail + ", whUserCont=" + whUserCont
				+ ", whUserIdType=" + whUserIdType + ", whUserIdOther=" + whUserIdOther + ", whUserIdNum=" + whUserIdNum
				+ "]";
	}
	
}
