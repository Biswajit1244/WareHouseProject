package com.biss.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OrderTab")
public class OrderMethod {
	@Id
	@GeneratedValue(generator = "orgen")
	@SequenceGenerator(name ="orgen",sequenceName = "orIdGen",
						allocationSize = 1,initialValue = 10000)
	@Column(name="or_id")
	private Integer orderId;
	@Column(name="or_mode")
	private String orderMode;
	@Column(name="or_code")
	private String orderCode;
	@Column(name="or_type")
	private String orderType;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="or_acpt_tab",joinColumns = @JoinColumn(name="or_id"))
	@OrderColumn(name="pos")
	@Column(name="or_acpt")
	private List<String> orderAcpt;
	@Column(name="or_desc")
	private  String decription;
	
	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<String> getOrderAcpt() {
		return orderAcpt;
	}

	public void setOrderAcpt(List<String> orderAcpt) {
		this.orderAcpt = orderAcpt;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderType=" + orderType + ", orderAcpt=" + orderAcpt + ", decription=" + decription + "]";
	}
	
	
}
