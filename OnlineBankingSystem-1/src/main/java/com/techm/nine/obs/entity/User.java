package com.techm.nine.obs.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String mobileNumber;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false, unique = true)
	private Long govtId;


	@OneToOne(mappedBy = "user")
    private Account account;

	public User() {

	}

	public User(Long id, String name, String email, String password, String mobileNumber, String address, Long govtId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.govtId = govtId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getGovtId() {
		return govtId;
	}

	public void setGovtId(Long govtId) {
		this.govtId = govtId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", govtId=" + govtId + "]";
	}
}
