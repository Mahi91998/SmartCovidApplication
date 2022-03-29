package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Doctor;
import com.service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	DoctorService Doctorservice;
	//Logger logger= System.getLogger("loger");
	
	@GetMapping("/hello")
	public String Hello()
	{
		return "Hello World";	
	}
	
	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor D)
	{
		Doctor D1=Doctorservice.addDoctor(D);
		ResponseEntity re=new ResponseEntity<Doctor>(D1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getDoctor")
	public ResponseEntity<List<Doctor>> getDoctor()
	{
		List<Doctor> lc1=Doctorservice.getDoctor();
		ResponseEntity re=new ResponseEntity<List<Doctor>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor d) throws Throwable
	{
		Doctor d1=Doctorservice.updateDoctor(d);
		
		ResponseEntity re=new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteDoctorById/{did}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int did)
	{
		Doctorservice.deleteDoctorByID(did);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDoctorById/{did}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int did)
	{
		Doctor d1 = (Doctor) Doctorservice.getDoctorByID(did);
		ResponseEntity<Doctor> re = new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDoctorByEmail/{eid}")
	public ResponseEntity<Doctor> getDoctorByEmail(@PathVariable String eid)
	{
		Doctor d1 = Doctorservice.getDoctorByEmail(eid);
		ResponseEntity<Doctor> re = new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateDoctorByEmail/{email}")
	public ResponseEntity<Doctor> updateDoctorByEmail(@PathVariable String email,@RequestBody Doctor d)
	{
		Doctor d1 = Doctorservice.updateDoctorByEmail(email, d);
		ResponseEntity<Doctor> re = new ResponseEntity<Doctor>(d1,HttpStatus.OK);
		return re;
	}
}