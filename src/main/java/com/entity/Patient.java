package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.aspectj.apache.bcel.ExceptionConstants;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@NotNull
    @Size(min = 2, message = "first Name should have at least 2 char")
	private String name;
	@NotNull
    @Pattern(regexp="[7-9][0-9]{9}", message="Number must contains no. and length should be 10 ")
	private String mobileNo;
	@NotNull
	private String address;
	/*
	 * @NotNull
	 * 
	 * @NotEmpty(message = "Date is required")
	 * 
	 * @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="MM/dd/yyyy")
	 */
	private String date;
	
	/*
	 * @NotNull
	 * 
	 * @NotEmpty(message = "Symptoms is required")
	 * 
	 * @Pattern(regexp = "^[a-zA-Z]+$",message
	 * ="Only alphabates and numeric are allowed")
	 */	 
	private String symptoms;
	
	@Email
	private String email; 
	
	/*
	 * @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="aid") private Appointment appoinement;
	 */
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	  
	  @JoinColumn(name="doctorID") private Doctor doctor;
	 
	
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPid1() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", name=" + name + ", mobileNo=" + mobileNo + ", address=" + address + ", date="
				+ date + ", symptoms=" + symptoms + ", email=" + email + ", getSymptoms()=" + getSymptoms()
				+ ", getPid()=" + getPid() + ", getName()=" + getName() + ", getMobileNo()=" + getMobileNo()
				+ ", getAddress()=" + getAddress() + ", getDate()=" + getDate() + ", getPid1()=" + getPid1()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
