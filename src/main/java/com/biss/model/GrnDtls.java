package com.biss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grndtl_tab")
public class GrnDtls {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String partCode;
	private Double baseCost;
	private Integer qnty;
	
	private String partStatus;
	
	@ManyToOne
	@JoinColumn(name="grn_id_fk")
	private GRN grn;

	public GrnDtls() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Integer getQnty() {
		return qnty;
	}

	public void setQnty(Integer qnty) {
		this.qnty = qnty;
	}

	public String getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}

	public GRN getGrn() {
		return grn;
	}

	public void setGrn(GRN grn) {
		this.grn = grn;
	}

	@Override
	public String toString() {
		return "GrnDtls [id=" + id + ", partCode=" + partCode + ", baseCost=" + baseCost + ", qnty=" + qnty
				+ ", partStatus=" + partStatus + ", grn=" + grn + "]";
	}
	
	
}
