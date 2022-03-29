package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Appointment;
import com.repository.AppointmentRepo;

@Service
public class AppointmentService {
	@Autowired
	
	AppointmentRepo repo;
	 public Appointment addAppointment(Appointment a)
	 {
		 repo.save(a);
		 return a;
	 }
	public List<Appointment> getAppointments()
	{
		List<Appointment> lc1=repo.findAll();
		 return lc1;
		
	}
	public Appointment getAppointmentById(int aid)throws Throwable{
		Appointment a=repo.findById(aid).orElseThrow();
		return a;
	}
	public  String deleteAppointmentById(int aid)
	{
		repo.deleteById(aid);
		return "Deleted";
		
	}
	public String deleteAppointment(Appointment a) {
		repo.delete(a);
		return "deleted";
	}
	public Appointment updateAppointment(Appointment a)throws Throwable
	{
		int id=a.getAid();
		Appointment a1=repo.findById(id).orElseThrow();
		
		a1.setTime(a.getTime());
		a1.setDate(a.getDate());
		repo.save(a1);
		return a1;
	}
	public List<Appointment> addAppointments(List<Appointment > ls)
	{
		repo.saveAll(ls);
		return ls;
	}

		
	}
	
