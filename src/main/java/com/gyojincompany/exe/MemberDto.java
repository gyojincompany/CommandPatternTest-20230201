package com.gyojincompany.exe;

import java.sql.Timestamp;

public class MemberDto {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private Timestamp jointime;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(String id, String password, String name, String email, Timestamp jointime) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.jointime = jointime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getJointime() {
		return jointime;
	}
	public void setJointime(Timestamp jointime) {
		this.jointime = jointime;
	}
	
}
