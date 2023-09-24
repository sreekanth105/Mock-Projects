package com.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "admin_login")
public class Admin {
	@Id
	@Column(unique = true)
	private String ausername;
	private String apassword;

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public Admin() {
	}

	public Admin(String ausername, String apassword) {
		this.ausername = ausername;
		this.apassword = apassword;
	}
}