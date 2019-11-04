package com.ust.model;

public class LoginUser {
	private Integer id;
	private String username;
	private String password;
	private Integer roleid;
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUser(Integer id, String username, String password, Integer roleid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", roleid=" + roleid + "]";
	}
	

}