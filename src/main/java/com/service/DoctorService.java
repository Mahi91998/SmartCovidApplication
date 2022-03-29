package com.service;

import java.util.List;
import java.util.Optional;
//import java.util.function.Supplier;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Doctor;
import com.repository.DoctorRepo;
import com.advices.*;

@Service
public class DoctorService {

	@Autowired 
	DoctorRepo repo;
	
	public Doctor addDoctor(Doctor d)
	{
		repo.save(d);
		return d;
	}
	
	public List<Doctor> getDoctor()
	{
		List<Doctor> lc1=repo.findAll();
		
		return lc1;
	}
	
	public String deleteDoctorByID(int id)
	{
		repo.deleteById(id);
		return "Doctor Deleted Sucessfully";
	}
	
	public Doctor getDoctorByID(int id)
	{
		Optional<Doctor> d = repo.findById(id);
		Doctor d1 = new Doctor();
		d1 = d.get();
		return d1;
	}
	
	public Doctor updateDoctor(Doctor d) throws Throwable
	{
		int id = d.getDoctorID();
		
		Supplier s1= ()->new ResourceNotFoundException("Doctor Does not exist in the database");
		Doctor d1=repo.findById(id).orElseThrow(s1);
		
		d1.setDoctorName(d.getDoctorName());
		d1.setLeaveDay(d.getLeaveDay());
		d1.setDoctorSpecialist(d.getDoctorSpecialist());
		
		repo.save(d1);
		return d1;
	}
	
	public Doctor getDoctorByEmail(String email)
	{
		Doctor d  =  repo.findByemail(email);
		return d;

	}
	
	public Doctor updateDoctorByEmail(String email, Doctor d)
	{
		Doctor d1 = repo.findByemail(email);
		d1.setDoctorName(d.getDoctorName());
		d1.setDoctorSpecialist(d.getDoctorSpecialist());
		d1.setLeaveDay(d.getLeaveDay());
		d1.setMobile(d.getMobile());
		repo.save(d1);
		return d1;
	}
}
