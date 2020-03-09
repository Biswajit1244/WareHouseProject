package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="part_tab")
public class Part {
	@Id
	@Column(name="pid")
	@GeneratedValue(generator = "partSq")
	@GenericGenerator(name="partSq",strategy = "increment")
	private Integer partId;
	@Column(name="p_code")
	private String partCode;
	@Column(name="P_width")
	private Double partWidth;
	@Column(name="p_length")
	private Double partLength;
	@Column(name="p_height")
	private Double partHeight;
	@Column(name="p_bcost")
	private Double partBCost;
	@Column(name="p_currency")
	private String partCurrency;
	
	@ManyToOne
	@JoinColumn(name="uomidfk")
	private UomType uom;
	
	@ManyToOne
	@JoinColumn(name="omIdSaleFk")
	private  OrderMethod omObSale;
	
	@ManyToOne
	@JoinColumn(name="omIdPurFk")
	private  OrderMethod omObPur;
	
	@Column(name="p_desc")
	private String partDesc;
	public Part() {
		super();
	}
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public Double getPartWidth() {
		return partWidth;
	}
	public void setPartWidth(Double partWidth) {
		this.partWidth = partWidth;
	}
	public Double getPartLength() {
		return partLength;
	}
	public void setPartLength(Double partLength) {
		this.partLength = partLength;
	}
	public Double getPartHeight() {
		return partHeight;
	}
	public void setPartHeight(Double partHeight) {
		this.partHeight = partHeight;
	}
	public Double getPartBCost() {
		return partBCost;
	}
	public void setPartBCost(Double partBCost) {
		this.partBCost = partBCost;
	}
	public String getPartCurrency() {
		return partCurrency;
	}
	public void setPartCurrency(String partCurrency) {
		this.partCurrency = partCurrency;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	public UomType getUom() {
		return uom;
	}
	public void setUom(UomType uom) {
		this.uom = uom;
	}
	public OrderMethod getOmObSale() {
		return omObSale;
	}
	public void setOmObSale(OrderMethod omObSale) {
		this.omObSale = omObSale;
	}
	public OrderMethod getOmObPur() {
		return omObPur;
	}
	public void setOmObPur(OrderMethod omObPur) {
		this.omObPur = omObPur;
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partLength="
				+ partLength + ", partHeight=" + partHeight + ", partBCost=" + partBCost + ", partCurrency="
				+ partCurrency + ", uom=" + uom + ", omObSale=" + omObSale + ", omObPur=" + omObPur + ", partDesc="
				+ partDesc + "]";
	}
	
	
	
}
