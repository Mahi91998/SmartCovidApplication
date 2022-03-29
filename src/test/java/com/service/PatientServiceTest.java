package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Patient;
import com.repository.PatientRepo;

@SpringBootTest
class PatientServiceTest {

	@InjectMocks
	PatientService patientService;
	
	@Mock
	PatientRepo patientRepo;
	
	  @Test 
	  void testAddPatient()
	  { 
		  Patient p1=new Patient();
		  p1.setPid(1);
		  p1.setName("Maheshwri"); 
		  p1.setMobileNo("9687644433");
		  p1.setAddress("Pune");
		  p1.setDate("03/13/2020");
		  p1.setAddress("xyz@gmail.com");
		  p1.setSymptoms("cough,fever");
		  Mockito.when(patientRepo.save(p1)).thenReturn(p1);
	    //  Mockito.when(patientRepo.save(p1)).thenReturn(p1);
	  
	  assertThat(patientService.addPatient(p1)).isEqualTo(p1);
	  
	  
	  }
	  
	  @Test void testGetPatients() 
	  {
	  Patient p1=new Patient();
	  p1.setPid(1);
	  p1.setName("Maheshwari"); 
	  p1.setMobileNo("9604422663");
	  p1.setAddress("Pune");
	  Patient p2=new Patient();
	  p1.setPid(2);
	  p1.setName("Abhishek");
	  p1.setMobileNo("9921138931");
	  p1.setAddress("Latur");
	  
	  List<Patient> patientList= new ArrayList<>(); patientList.add(p1);
	  patientList.add(p2);
	  
	  }
	 

	@Test
	void testGetPatientById() throws Throwable
	{

		Patient c1 = new Patient();
		c1.setPid(3);;
		c1.setName("Maheshwari");
		c1.setMobileNo("9604422663");
		c1.setAddress("Pune");
		c1.setDate("03/15/2022");
		c1.setEmail("Xyz@gmail.com");
		c1.setAddress("Cold,cough,fever");
		
		Optional<Patient> c4= Optional.of(c1);
		
	    Mockito.when(patientRepo.findById(3)).thenReturn(c4);
	    
	    assertThat(patientService.getPatientById(3)).isEqualTo(c1);
	}

	@Test
	void testUpdateCoder() throws Throwable 
	{
		Patient c1 = new Patient();
		c1.setPid(3);;
		c1.setName("Maheshwari");
		c1.setMobileNo("9604422663");
		c1.setAddress("Pune");
		c1.setDate("03/15/2022");
		c1.setEmail("Xyz@gmail.com");
		c1.setAddress("Cold,cough,fever");
		Optional<Patient> c4= Optional.of(c1);
		Mockito.when(patientRepo.findById(3)).thenReturn(c4);
		c1.setPid(3);;
		c1.setName("Maheshwari");
		c1.setMobileNo("9604422663");
		c1.setAddress("Pune");
		c1.setDate("03/15/2022");
		c1.setEmail("Xyz@gmail.com");
		c1.setAddress("Cold,cough,fever");
		
		assertThat(patientService.updateCoder(c1)).isEqualTo(c1);
	    
		
	}
	
}
