package com.example.entities;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inquery 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String phoneno;
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String interestedCourse;
	@Column(nullable = false)
	private String discussion;
	@Column(nullable = false)
	private String inqueryType;
	@Column(nullable = false)
	private String callType;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String employeeEmail;
	
	@Column(nullable = false)
	private Date inqueryDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getInterestedCourse() {
		return interestedCourse;
	}
	public void setInterestedCourse(String interestedCourse) {
		this.interestedCourse = interestedCourse;
	}
	public String getDiscussion() {
		return discussion;
	}
	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}
	public String getInqueryType() {
		return inqueryType;
	}
	public void setInqueryType(String inqueryType) {
		this.inqueryType = inqueryType;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public Date getInqueryDate() {
		return inqueryDate;
	}
	public void setInqueryDate(Date inqueryDate) {
		this.inqueryDate = inqueryDate;
	}
	
}
