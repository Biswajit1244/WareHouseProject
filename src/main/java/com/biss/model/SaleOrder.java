package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sale_order_tab")
public class SaleOrder {
	@Id
	@GeneratedValue(generator = "salesq")
	@SequenceGenerator(name ="salesq",sequenceName = "saleOrGen",
					allocationSize = 1,initialValue = 10203)
	@Column(name="saleid")
	private Integer saleOrId;
	@Column(name="ref_num")
	private String saleOrRefNum;
	@Column(name="stock_mode")
	private String saleOrStkMode;
	@Column(name="stock_source")
	private String saleOrStkSource;
	@Column(name="status")
	private final String saleOrStatus="SALE-OPEN";
	@Column(name="sale_desc")
	private String saleOrDesc;
	public SaleOrder() {
		super();
	}
	public SaleOrder(Integer saleOrId) {
		super();
		this.saleOrId = saleOrId;
	}
	public Integer getSaleOrId() {
		return saleOrId;
	}
	public void setSaleOrId(Integer saleOrId) {
		this.saleOrId = saleOrId;
	}
	public String getSaleOrRefNum() {
		return saleOrRefNum;
	}
	public void setSaleOrRefNum(String saleOrRefNum) {
		this.saleOrRefNum = saleOrRefNum;
	}
	public String getSaleOrStkMode() {
		return saleOrStkMode;
	}
	public void setSaleOrStkMode(String saleOrStkMode) {
		this.saleOrStkMode = saleOrStkMode;
	}
	public String getSaleOrStkSource() {
		return saleOrStkSource;
	}
	public void setSaleOrStkSource(String saleOrStkSource) {
		this.saleOrStkSource = saleOrStkSource;
	}
	public String getSaleOrDesc() {
		return saleOrDesc;
	}
	public void setSaleOrDesc(String saleOrDesc) {
		this.saleOrDesc = saleOrDesc;
	}
	public String getSaleOrStatus() {
		return saleOrStatus;
	}
	@Override
	public String toString() {
		return "SaleOrder [saleOrId=" + saleOrId + ", saleOrRefNum=" + saleOrRefNum + ", saleOrStkMode=" + saleOrStkMode
				+ ", saleOrStkSource=" + saleOrStkSource + ", saleOrStatus=" + saleOrStatus + ", saleOrDesc="
				+ saleOrDesc + "]";
	}
	
	
}
