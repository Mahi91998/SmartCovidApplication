package com.controller;
import java.util.List;
import org.apache.tomcat.websocket.server.Constants;
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

import com.entity.Appointment;

import com.service.AppointmentService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping( "/app")
public class AppointmentController{
	
@Autowired
AppointmentService appointmentservice;
@RequestMapping("/Hello")
public String hello()
{
	String msg="Welcome to Spring Data Jpa";
	return msg;
}

@PostMapping("/addAppointment")
public ResponseEntity<Appointment>addAppointment(@RequestBody Appointment a)
{

		 Appointment a1 = appointmentservice.addAppointment(a);
	
	ResponseEntity re=new ResponseEntity<Appointment>(a1,HttpStatus.OK);
	return re;
}

@GetMapping("/getAppointmet")
public ResponseEntity<List<Appointment>> getAppointment()
{
	List<Appointment> lc1=appointmentservice.getAppointments();
	ResponseEntity re=new ResponseEntity<List<Appointment>>(lc1,HttpStatus.OK);
	return re;
}

@GetMapping(path="/getAppointment/{aid}")
public ResponseEntity<Appointment> getCoderById(@PathVariable int aid) throws Throwable
{
	
	Appointment	a1 = appointmentservice.getAppointmentById(aid);
	ResponseEntity re=new ResponseEntity<Appointment>(a1,HttpStatus.OK);
	return re;
}

@PostMapping(path="/addAppointments")
public ResponseEntity<List<Appointment>> addAppointments(@RequestBody List<Appointment> ls)
{
	List<Appointment> le=appointmentservice.addAppointments(ls);
	ResponseEntity re=new ResponseEntity<List<Appointment>>(le,HttpStatus.OK);
	return re;
}

@PutMapping(path="/updateAppointment")
public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment e) throws Throwable
{
	Appointment e1=appointmentservice.updateAppointment(e);
	ResponseEntity re=new ResponseEntity<Appointment>(e1,HttpStatus.OK);
	return re;
}

@DeleteMapping(path="/deleteAppointment")
public ResponseEntity<String> deleteCoder(@RequestBody Appointment e)
{
	appointmentservice.deleteAppointment(e);
	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
}

@DeleteMapping(path="/deleteAppointmentById/{aid}")
public ResponseEntity<String> deleteAppointmentById(@PathVariable int aid)
{
	appointmentservice.deleteAppointmentById(aid);
	ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
	return re;
 }


 

}

