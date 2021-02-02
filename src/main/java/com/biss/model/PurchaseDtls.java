package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="purchasedtls_tab")
public class PurchaseDtls {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer purDtlsId;
	
	@Transient
	private Integer slNo;
	
	@Column(name="dqty")
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name="dtls_po_fk")
	private Purchase pur;
	
	@ManyToOne
	@JoinColumn(name="dtls_part_fk")
	private Part part;

	public PurchaseDtls() {
		super();
	}

	public Integer getPurDtlsId() {
		return purDtlsId;
	}

	public void setPurDtlsId(Integer purDtlsId) {
		this.purDtlsId = purDtlsId;
	}

	public Integer getSlNo() {
		return slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Purchase getPur() {
		return pur;
	}

	public void setPur(Purchase pur) {
		this.pur = pur;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	@Override
	public String toString() {
		return "PurchaseDtls [purDtlsId=" + purDtlsId + ", slNo=" + slNo + ", qty=" + qty + ", pur=" + pur + ", part="
				+ part + "]";
	}

	
	
}
