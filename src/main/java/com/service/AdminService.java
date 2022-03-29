package com.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.Admin;
import com.advices.ResourceNotFoundException;


import com.repository.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo repo;

	public Admin addAdmin(Admin a)                   //Add Admit
		{
		repo.save(a);
		return a;
		}

	public Admin updateAdmin(Admin a) throws Throwable {     //Update Admits
		int id=a.getAdminId();
		
	Supplier s1= ()->new ResourceNotFoundException("Admin Does not exist in the database");
		Admin a1=repo.findById(id).orElseThrow();
		
		a1.setadminUsername(a.getadminUsername());
			a1.setAdminMail(a.getAdminMail());
			repo.save(a1);
			return a1;	
	}


	//public List<AdminEntity> getAdmins()         //getAdmin
	//{
//		List<AdminEntity> la1=repo.findAll();
//		return la1;
	//}

	public Admin getAdminById(int adminId) throws Throwable      //getAdminById
	{
	Supplier s1= ()->new ResourceNotFoundException("Admin Does not exist in the database");
		Admin a=repo.findById(adminId).orElseThrow();
		return a;
	}


	public String deleteAdminById(int adminId) {        //deleteAdminById
		repo.deleteById(adminId);
		return "Deleted";
	}


	public String deleteDoctorById(int Doctor_Id) {        //deleteDoctorById
	
		repo.deleteById(Doctor_Id);
		return "Deleted";
	}

	public Admin getDoctor(String doctor_name) {
		 Admin d=((AdminService) repo).getDoctor(doctor_name);
  	    return d;
	}











	//
	//public String deleteAdmin(AdminEntity a) {    //DeleteAdmin
	//repo.delete(a);
	//return "Deleted";
	//}


	//public AdminEntity getAdminByadminUsername (String adminUsername) //GetAdminByName
	//{
//	    AdminEntity a=repo.FindByadminUsername(adminUsername);
//	    return a;
	//}


	//public List<AdminEntity> findByAdminMailSorted(String adminMail) 
	//{
//		List<AdminEntity> la1= repo.findByAdminMailSorted(adminMail);
	//return la1;
	//}



//
//	public AdminEntity getDoctor(String doctor_name)
//	{
//	    AdminEntity d=repo.getDoctor(doctor_name);
//	    return d;
//	}

}
