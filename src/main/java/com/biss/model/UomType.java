package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UOMTAB")
public class UomType {
	@Id
	@GeneratedValue
	@Column(name="UOMID")
	private Integer uomId;
	@Column(name="UTYPE")
	private String uomType;
	@Column(name="UMODEL")
	private String uomModel;
	@Column(name="DESCRIPTION")
	private String uomDesc;
	public UomType() {
		super();
	}
	public UomType(Integer uomId) {
		super();
		this.uomId = uomId;
	}
	public Integer getUomId() {
		return uomId;
	}
	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}
	public String getUomType() {
		return uomType;
	}
	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	public String getUomModel() {
		return uomModel;
	}
	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}
	public String getUomDesc() {
		return uomDesc;
	}
	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}
	
	@Override
	public String toString() {
		return "UomType [uomId=" + uomId + ", uomType=" + uomType + ", uomModel=" + uomModel + ", uomDesc=" + uomDesc
				+ "]";
	}
}
