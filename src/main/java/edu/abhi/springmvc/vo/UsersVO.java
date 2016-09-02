package edu.abhi.springmvc.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rental_users")
public class UsersVO {
	
	private String userId;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private Date reg_date;
	private String status;	
	private int level;
	
	public UsersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UsersVO(String userId, String password,
			String rePassword, String name, String email,
			String address, String phone, Date regDate, String status,
			int level) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		reg_date = regDate;
		this.status = status;
		this.level = level;
	}

	@Id 
	@Column(name = "id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "reg_date")
	public Date getRegDate() {
		return reg_date;
	}
	public void setRegDate(Date regDate) {
		reg_date = regDate;
	}
  
	
	@Column(name = "level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "UsersVO [address=" + address + ", name="
				+ name + ", level=" + level
				+ ", mail_id=" + email + ", password=" + password
				+ ", phone_number=" + phone + ",reg_date=" + reg_date + ", status=" + status
				+ ", user_id=" + userId + "]";
	}

	
}


