package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="saletab")
public class Sale {
	@Id
	@GeneratedValue(generator = "orGen")
	@SequenceGenerator(name="orGen",sequenceName = "orderGen",
					initialValue =142656,allocationSize = 1)
	@Column(name="id")
	private Integer saleId;
	@Column(name="order_code")
	private  String saleOrderCode;
	@Column(name="Ref_num")
	private String saleRefNo;
	@Column(name="stock_mode")
	private String saleStkMode;
	@Column(name="stock_source")
	private String saleStkSource;
	@Column(name="default_status")
	private String saleDfltSts;
	@Column(name="description")
	private String saleDes;
	public Sale() {
		super();
	}
	public Sale(Integer saleId) {
		super();
		this.saleId = saleId;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getSaleOrderCode() {
		return saleOrderCode;
	}
	public void setSaleOrderCode(String saleOrderCode) {
		this.saleOrderCode = saleOrderCode;
	}
	public String getSaleRefNo() {
		return saleRefNo;
	}
	public void setSaleRefNo(String saleRefNo) {
		this.saleRefNo = saleRefNo;
	}
	public String getSaleStkMode() {
		return saleStkMode;
	}
	public void setSaleStkMode(String saleStkMode) {
		this.saleStkMode = saleStkMode;
	}
	public String getSaleStkSource() {
		return saleStkSource;
	}
	public void setSaleStkSource(String saleStkSource) {
		this.saleStkSource = saleStkSource;
	}
	public String getSaleDes() {
		return saleDes;
	}
	public void setSaleDes(String saleDes) {
		this.saleDes = saleDes;
	}
	public String getSaleDfltSts() {
		return saleDfltSts;
	}
	public void setSaleDfltSts(String saleDfltSts) {
		this.saleDfltSts = saleDfltSts;
	}
	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", saleOrderCode=" + saleOrderCode + ", saleRefNo=" + saleRefNo
				+ ", saleStkMode=" + saleStkMode + ", saleStkSource=" + saleStkSource + ", saleDfltSts=" + saleDfltSts
				+ ", saleDes=" + saleDes + "]";
	}
	
}
