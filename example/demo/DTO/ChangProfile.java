package com.example.demo.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class ChangProfile {
	private String Fullname;
	private Date Birth;
	private String username;
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public Date getBirth() {
		return Birth;
	}
	public void setBirth(Date birth) {
		Birth = birth;
	}
	public ChangProfile(String fullname, Date birth) {
		super();
		Fullname = fullname;
		Birth = birth;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
}
