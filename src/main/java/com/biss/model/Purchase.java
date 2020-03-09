package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="purchasetab")
public class Purchase {
	@Id
	@GeneratedValue(generator = "purGen")
	@SequenceGenerator(name="purGen",sequenceName = "PGen",
						initialValue =1010,allocationSize =1)
	@Column(name="pid")
	private Integer purId;
	@Column(name="pcode")
	private String purCode;
	@Column(name="p_ref_num")
	private String purRefNum;
	@Column(name="P_quality_chk")
	private String purQtChck;
	@Column(name="p_deflt_stats")
	private String purDfltSts;
	@Column(name="description")
	private String purDesc;
	public Purchase() {
		super();
	}
	public Purchase(Integer purId) {
		super();
		this.purId = purId;
	}
	
	public Integer getPurId() {
		return purId;
	}
	public void setPurId(Integer purId) {
		this.purId = purId;
	}
	public String getPurCode() {
		return purCode;
	}
	public void setPurCode(String purCode) {
		this.purCode = purCode;
	}
	public String getPurRefNum() {
		return purRefNum;
	}
	public void setPurRefNum(String purRefNum) {
		this.purRefNum = purRefNum;
	}
	public String getPurQtChck() {
		return purQtChck;
	}
	public void setPurQtChck(String purQtChck) {
		this.purQtChck = purQtChck;
	}
	public String getPurDfltSts() {
		return purDfltSts;
	}
	public void setPurDfltSts(String purDfltSts) {
		this.purDfltSts = purDfltSts;
	}
	public String getPurDesc() {
		return purDesc;
	}
	public void setPurDesc(String purDesc) {
		this.purDesc = purDesc;
	}
	@Override
	public String toString() {
		return "Purchase [purId=" + purId + ", purCode=" + purCode + ", purRefNum=" + purRefNum + ", purQtChck="
				+ purQtChck + ", purDfltSts=" + purDfltSts + ", purDesc=" + purDesc + "]";
	}
	
}
