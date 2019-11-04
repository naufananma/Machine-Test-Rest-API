package com.ust.model;

public class ContactVendor {
	
	private Integer vid;
	private String vname;
	private String vaddress;
	private String vlocation;
	private String vservice;
	private Double pincode; 
	private String isactive;
	
	private Integer cid ;
	private String cname ;
	private String department;
	private String email;
	private String phone ;
	
	public ContactVendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactVendor(Integer vid, String vname, String vaddress, String vlocation, String vservice, Double pincode,
			String isactive, Integer cid, String cname, String department, String email, String phone) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vaddress = vaddress;
		this.vlocation = vlocation;
		this.vservice = vservice;
		this.pincode = pincode;
		this.isactive = isactive;
		this.cid = cid;
		this.cname = cname;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVaddress() {
		return vaddress;
	}
	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}
	public String getVlocation() {
		return vlocation;
	}
	public void setVlocation(String vlocation) {
		this.vlocation = vlocation;
	}
	public String getVservice() {
		return vservice;
	}
	public void setVservice(String vservice) {
		this.vservice = vservice;
	}
	public Double getPincode() {
		return pincode;
	}
	public void setPincode(Double pincode) {
		this.pincode = pincode;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
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
	
	@Override
	public String toString() {
		return "ContactVendor [vid=" + vid + ", vname=" + vname + ", vaddress=" + vaddress + ", vlocation=" + vlocation
				+ ", vservice=" + vservice + ", pincode=" + pincode + ", isactive=" + isactive + ", cid=" + cid
				+ ", cname=" + cname + ", department=" + department + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
	