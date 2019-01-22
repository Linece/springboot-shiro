package com.zdc.shiro.model;

import java.util.Date;

public class User {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String password;
	
	private Date create_date;
	
	private Date update_date;
	
	private String perms;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	
	
	
}
