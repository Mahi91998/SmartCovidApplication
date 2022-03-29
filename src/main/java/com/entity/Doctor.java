package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	private int doctorID;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$",message="Doctor name contains only alphabets.")
	private String doctorName;
	private String leaveDay;
	private String doctorSpecialization;
	
	@NotNull
	@Pattern(regexp="^(.+)@(\\S+)$",message="Enter valid Email Id.")
	private String email;
	
	@NotNull
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message="Insert valid phone number.")
	private String mobile;
	/*
	 * 
	 * @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="pid") private Patient patient;
	 * 
	 */
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(String leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getDoctorSpecialist() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialist(String doctorSpecialist) {
		this.doctorSpecialization = doctorSpecialist;
	}
	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", doctorName=" + doctorName + ", leaveDay=" + leaveDay
				+ ", doctorSpecialization=" + doctorSpecialization + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
}
