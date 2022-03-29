package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Admin;
import com.service.AdminService;
import com.service.AppointmentService;
import com.service.DoctorService;
import com.service.PatientService;


@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "*")
public class AdminController {
	private DoctorService Doctorservice;


	public AdminController(AdminService adminservice, DoctorService doctorservice, PatientService patientservice,AppointmentService appointmentservice) {
		super();
		this.adminservice = adminservice;
		this.Doctorservice = doctorservice;
		this.patientservice = patientservice;
		this.appointmentservice = appointmentservice;
	}

@Autowired
private AdminService adminservice;

@Autowired
private DoctorService doctorrservice;

@Autowired
private PatientService patientservice;

@Autowired
private AppointmentService appointmentservice;


//
//@GetMapping(path="/getAdmins")
//public ResponseEntity <List<AdminEntity>> getAdmins()
//{
//
//
//List<AdminEntity> lf1 = adminservice.getAdmins();
//ResponseEntity re = new ResponseEntity<List<AdminEntity>>(lf1,HttpStatus.OK);
//return re;
//}

@GetMapping(path="/getAdmin/{adminId}")
public ResponseEntity <Admin> getAdminById(@PathVariable int adminId) throws Throwable
{
Admin a1 = adminservice.getAdminById(adminId);
ResponseEntity re = new ResponseEntity<Admin>(a1,HttpStatus.OK);
return re;
}

@PostMapping(path="/addAdmin")
public ResponseEntity <Admin> addAdmin(@RequestBody Admin a)
{
Admin a1 = adminservice.addAdmin(a);
ResponseEntity re = new ResponseEntity<Admin>(a1,HttpStatus.OK);
return re;
}

//@PostMapping(path="/addAdmins")
//public ResponseEntity<List<AdminEntity>> addAdmins(@RequestBody List<AdminEntity> ls)
//{
//	List<AdminEntity> le=adminservice.addAdmins(ls);
//	
//	ResponseEntity re=new ResponseEntity<List<AdminEntity>>(le,HttpStatus.OK);
//	return re;
//}


@PutMapping(path="/updateAdmin")
public ResponseEntity<Admin> updateAdmin(@RequestBody Admin e) throws Throwable
{
	Admin e1=adminservice.updateAdmin(e);
	
	ResponseEntity re=new ResponseEntity<Admin>(e1,HttpStatus.OK);
	return re;
}

//@DeleteMapping(path="/deleteAdmin")
//public ResponseEntity <String> deleteAdmin(@RequestBody AdminEntity e)
//{
//adminservice.deleteAdmin(e);
//ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
//return re;
//}

@DeleteMapping(path="/deleteAdminById/{adminId}")
public ResponseEntity <String> deleteAdminById(@PathVariable int adminId)
{
adminservice.deleteAdminById(adminId);
ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
return re;
}

//
@DeleteMapping(path="/deleteDoctorById/{doctor_id}")														
public ResponseEntity <String> deleteDoctorById(@PathVariable int doctor_Id)
{
adminservice.deleteDoctorById(doctor_Id);
ResponseEntity re = new ResponseEntity<String>("Deleted",HttpStatus.OK);
return re;
}

//@GetMapping("/getAdminByadminUsername/{adminUsername}")
//public ResponseEntity<AdminEntity> getAdminByadminUsername(@PathVariable String adminUsername)
//{
//	AdminEntity a=adminservice.getAdminByadminUsername(adminUsername);
//	ResponseEntity re =new ResponseEntity<AdminEntity>(a,HttpStatus.OK);
//	return re;
//}

@GetMapping("/getDoctor/{doctor_name}")
public ResponseEntity<Admin> getDoctor(@PathVariable String doctor_name)
{
	Admin a=adminservice.getDoctor(doctor_name);
	ResponseEntity re =new ResponseEntity<Admin>(a,HttpStatus.OK);
	return re;
}









}




//@GetMapping("/getAdminByAdminMail/{adminMail}") 
//public ResponseEntity<List<AdminEntity>> findByAdminMailSorted(@PathVariable String adminMail) 
//{ 
//	  List<AdminEntity> la=adminservice.findByAdminMailSorted(adminMail); 
//	  ResponseEntity re=new ResponseEntity<List<AdminEntity>>(la,HttpStatus.OK); 
//	  return re; 
//	  }
//





