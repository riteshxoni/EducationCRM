package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@Pattern(regexp = "^(?=.{2,50}$)(?!.*[.\\-'\\s]{2})[A-Za-z]+(?:[ .'\\-][A-Za-z]+)*$", message = "Please Valid Name...")
	private String name;
	@Column
	@Pattern(regexp = "^(?=.{6,254}$)[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,63}$", message = "Please Valid Email...")
	private String email;
	@Column
	@Pattern(regexp = "^(?=.{8,64}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\\$%\\^&\\*\\(\\)\\-_+\\=\\[\\]\\{\\}\\|;:'\",<>\\.?\\/`~])[^\\s]+$", message = "Please Enter Strong Password...")
	private String password;
	@Column
	@Pattern(regexp = "^(?:\\+91[\\-\\s]?|91[\\-\\s]?|0)?[6-9]\\d{9}$", message = "Please Enter Valid Phone No.")
	private String phoneno;
	@Column
	@Pattern(regexp = "^(?=.{2,50}$)(?!.*[\\s\\-]{2})[A-Za-z]+(?:[ -][A-Za-z]+)*$", message = "Please Enter Valid City...")
	private String city;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean banStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean getBanStatus() {
		return banStatus;
	}
	public void setBanStatus(boolean banStatus) {
		this.banStatus = banStatus;
	}
	
	
	
}
