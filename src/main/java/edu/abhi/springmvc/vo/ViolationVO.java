package edu.abhi.springmvc.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "violation")
public class ViolationVO {
	
	private int v_id;
	private String vio_user_id ="";
	private int violation_count;
	private Date violation_date;
	private String active_or_inactive="";
	private String vehicle_no="";
	private String vio_comp_by="";
	

	@Id 
	@Column(name = "v_id")
	public int getVId() {
		return v_id;
	}
	public void setVId(int vId) {
		v_id = vId;
	}
	@Column(name = "vio_user_id")
	public String getVioUserId() {
		return vio_user_id;
	}
	public void setVioUserId(String vioUserId) {
		vio_user_id = vioUserId;
	}
	@Column(name = "violation_count")
	public int getViolationCount() {
		return violation_count;
	}
	public void setViolationCount(int violationCount) {
		violation_count = violationCount;
	}
	@Column(name = "violation_date")
	public Date getViolationDate() {
		return violation_date;
	}
	public void setViolationDate(Date violationDate) {
		violation_date = violationDate;
	}
	@Column(name ="active_or_inactive")
	public String getActiveOrInactive() {
		return active_or_inactive;
	}
	public void setActiveOrInactive(String activeOrInactive) {
		active_or_inactive = activeOrInactive;
	}
	@Column(name ="vehicle_no")
	public String getVehicleNo() {
		return vehicle_no;
	}
	public void setVehicleNo(String vehicleNo) {
		vehicle_no = vehicleNo;
	}
	@Column(name ="vio_comp_by")
	public String getVioCompBy() {
		return vio_comp_by;
	}
	public void setVioCompBy(String vioCompBy) {
		vio_comp_by = vioCompBy;
	}
	@Override
	public String toString() {
		return "ViolationVO [active_or_inactive="
				+ active_or_inactive + ",  v_id="
				+ v_id + ", vehicle_no=" + vehicle_no + ", vio_comp_by="
				+ vio_comp_by + ", vio_user_id=" + vio_user_id
				+ ", violation_count=" + violation_count + ", violation_date="
				+ violation_date + "]";
	}
	
	
	  	

}
