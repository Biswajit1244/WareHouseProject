package com.biss.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	//Shipment module  integration
	@ManyToOne
	@JoinColumn(name="shipIdFk")
	private ShipmentType shipOb;
	
	//WhUser Module Integration for vendor
	@ManyToOne
	@JoinColumn(name="whIdFk")
	private WhUserType whUserOb;
	
	@OneToMany(mappedBy = "pur",fetch = FetchType.EAGER)
	private List<PurchaseDtls> childs;
	
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
	public List<PurchaseDtls> getChilds() {
		return childs;
	}
	public void setChilds(List<PurchaseDtls> childs) {
		this.childs = childs;
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
	public ShipmentType getShipOb() {
		return shipOb;
	}
	public void setShipOb(ShipmentType shipOb) {
		this.shipOb = shipOb;
	}
	public WhUserType getWhUserOb() {
		return whUserOb;
	}
	public void setWhUserOb(WhUserType whUserOb) {
		this.whUserOb = whUserOb;
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
				+ purQtChck + ", purDfltSts=" + purDfltSts + ", shipOb=" + shipOb + ", whUserOb=" + whUserOb
				+ ", purDesc=" + purDesc + "]";
	}
	
	
}
