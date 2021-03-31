package com.alten.VechilePortel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vechileInfo")
public class VechilePortelBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String chassisId;
	private String type;
	private Byte numberOfPassengers ; 
	private String color;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChassisId() {
		return chassisId;
	}
	public void setChassisId(String chassisId) {
		this.chassisId = chassisId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Byte getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(Byte numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "VechilePortelBean [chassisId=" + chassisId + ", type=" + type + ", numberOfPassengers="
				+ numberOfPassengers + ", color=" + color + "]";
	}
}
