package com.ust.model;

public class Contact {
	
	
	private Integer cid ;
	private String cname ;
	private String department;
	private String email;
	private String phone ;
	private Integer vid ;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(Integer cid, String cname, String department, String email, String phone, Integer vid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.vid = vid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", cname=" + cname + ", department=" + department + ", email=" + email
				+ ", phone=" + phone + ", vid=" + vid + "]";
	}
	
	
}
	