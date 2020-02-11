package com.biss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmntTab")
public class ShipmentType {
	@Id
	@Column(name="sid")
	@GeneratedValue
	private Integer shipId;
	@Column(name="smode")
	private String shipMode;
	@Column(name="scode")
	private String shipCode;
	@Column(name="enbship")
	private String enbShip;
	@Column(name="sgrade")
	private String shipGrad;
	@Column(name="sdesc")
	private String shipDesc;
	
	public ShipmentType() {
		super();
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shioCode) {
		this.shipCode = shioCode;
	}

	public String getEnbShip() {
		return enbShip;
	}

	public void setEnbShip(String enbShip) {
		this.enbShip = enbShip;
	}

	public String getShipGrad() {
		return shipGrad;
	}

	public void setShipGrad(String shipGrad) {
		this.shipGrad = shipGrad;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}
	
	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", enbShip="
				+ enbShip + ", shipGrad=" + shipGrad + ", shipDesc=" + shipDesc + "]";
	}
}
