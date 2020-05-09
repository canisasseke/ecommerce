package com.zopenlab.ecommerceproduct.beans;

public class User {

	private String username;
	private String email;
	private String fullname;
	private String airdrome;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String email, String fullname, String airdrome) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.airdrome = airdrome;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAirdrome() {
		return airdrome;
	}

	public void setAirdrome(String airdrome) {
		this.airdrome = airdrome;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", fullname=" + fullname + ", airdrome="
				+ airdrome + "]";
	}
	  
}
