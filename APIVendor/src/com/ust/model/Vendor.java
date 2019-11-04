package com.ust.model;

public class Vendor {
	
	private Integer vid;
	private String vname;
	private String vaddress;
	private String vlocation;
	private String vservice;
	private Double pincode; 
	private String isactive;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(Integer vid, String vname, String vaddress, String vlocation, String vservice, Double pincode,
			String isactive) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vaddress = vaddress;
		this.vlocation = vlocation;
		this.vservice = vservice;
		this.pincode = pincode;
		this.isactive = isactive;
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
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", vaddress=" + vaddress + ", vlocation=" + vlocation
				+ ", vservice=" + vservice + ", pincode=" + pincode + ", isactive=" + isactive + "]";
	}
	
	
}