package com.anjz.model;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月18日下午4:45:27
 */
public class AbcUser {
	private String id;
	private String username;
	private String password;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
	
	@Override
	public String toString() {
		return "AbcUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
