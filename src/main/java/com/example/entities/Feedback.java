package com.example.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String std_name;
	@Column
	private String std_email;
	@Column
	private String std_course;
	@Column
	private String std_message;
	@Column
	private LocalDate date=LocalDate.now();
	@Column
	private LocalTime time=LocalTime.now();
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_email() {
		return std_email;
	}
	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}
	public String getStd_course() {
		return std_course;
	}
	public void setStd_course(String std_course) {
		this.std_course = std_course;
	}
	public String getStd_message() {
		return std_message;
	}
	public void setStd_message(String std_message) {
		this.std_message = std_message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
