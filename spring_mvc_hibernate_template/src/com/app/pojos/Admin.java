package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin_Info")
public class Admin {

	private Integer aid;
	private String name;
	private String email;
	private String password;
	
	public Admin() {
		System.out.println("in cnstr " + getClass().getName());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
