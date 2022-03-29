package com.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {

	
	@Id
	@GeneratedValue
	private int aid;
	
    @NotEmpty(message="date is required")
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private String date;
	
    @NotEmpty(message="time is required")
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:MM")
    private String time;
    
	/*
	 * @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="pid") private Patient patient;
	 * 
	 * @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="doctorID") private Doctor doctor;
	 */
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time =time ;
	}
	
	
	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", date=" + date + ", time=" + time + "]";
	}
	
}
	
	