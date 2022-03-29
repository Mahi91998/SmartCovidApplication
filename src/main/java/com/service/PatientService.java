package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;

import com.entity.Patient;
import com.repository.PatientRepo;


@Service
public class PatientService
{
	@Autowired
	PatientRepo repo;
	
	public Patient addPatient(Patient c)
	{
		
		 repo.save(c);	
		 return c;
	}
	
	public List<Patient> getPatients()
	{
		List<Patient> lc1=repo.findAll();
		
		return lc1;
	}
	public Patient getPatientById(int pid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Coder Does not exist in the database");
		Patient c=repo.findById(pid).orElseThrow(s1);
		return c;
	}
	
	
	public Patient updateCoder(Patient c) throws Throwable 
	{
		int id=c.getPid();
		
		Supplier s1= ()->new ResourceNotFoundException("Coder Does not exist in the database");
		Patient c1=repo.findById(id).orElseThrow(s1);
		
		c1.setName(c.getName());
			c1.setDate(c.getDate());
			c1.setSymptoms(c.getSymptoms());
			repo.save(c1);
			return c1;	
	}
	
	


	

}
