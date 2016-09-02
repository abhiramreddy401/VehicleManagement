package edu.abhi.springmvc.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_details")
public class VehicleDetailsVO {
	
	private int sno;
	private String user_id="";
	private String vehicle_number="";
	private String make = "";
	private String model="";
	private String year="";
	
	@Id
	@Column(name = "sno")
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}

	@Column(name = "user_id")
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		user_id = userId;
	}
	@Column(name = "vehicle_number")
	public String getVehicleNumber() {
		return vehicle_number;
	}
	public void setVehicleNumber(String vehicleNumber) {
		vehicle_number = vehicleNumber;
	}
	@Column(name = "make")
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	@Column(name = "model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "VehicleDetailsVO [make=" + make + ", model="
				+ model + ", sno=" + sno
				+ ", user_id=" + user_id + ", vehicle_number=" + vehicle_number
				+ ", year=" + year + "]";
	}
	
	
	

}
