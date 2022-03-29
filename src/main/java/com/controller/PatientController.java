package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Patient;
import com.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController
{
	@Autowired
	PatientService patientservice;
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient c)
	{
		Patient c1=patientservice.addPatient(c);
		ResponseEntity re=new ResponseEntity<Patient>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getPatients")
	public ResponseEntity<List<Patient>> getPatients()
	{
		List<Patient> lc1=patientservice.getPatients();
		ResponseEntity re=new ResponseEntity<List<Patient>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getPatient/{pid}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int pid) throws Throwable
	{
		Patient c1=patientservice.getPatientById(pid);
		ResponseEntity re=new ResponseEntity<Patient>(c1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updatePatient")
	public ResponseEntity<Patient> updateCoder(@RequestBody Patient e) throws Throwable
	{
		Patient e1=patientservice.updateCoder(e);
		
		ResponseEntity re=new ResponseEntity<Patient>(e1,HttpStatus.OK);
		return re;
	}
	
		  

	
}
