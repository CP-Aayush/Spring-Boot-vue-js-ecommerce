package dev.aayush.Ecommerce.model;
//package com.example.dbconnection.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//@Entity
//@Table(name = "userDetails")
//@EntityListeners(AuditingEntityListener.class)
//public class UserDetails {
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "id")
//	private User userId;
//	private String address;
//	private String landmark;
//	private String city;
//	private String state;
//	private String email;
//	private Long phoneNo;
//	
//	public User getUserId() {
//		return userId;
//	}
//	public void setUserId(User userId) {
//		this.userId = userId;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getLandmark() {
//		return landmark;
//	}
//	public void setLandmark(String landmark) {
//		this.landmark = landmark;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public Long getPhoneNo() {
//		return phoneNo;
//	}
//	public void setPhoneNo(Long phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	
//	
//}
