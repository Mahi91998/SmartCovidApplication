package com.service;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Doctor;
import com.repository.DoctorRepo;

@SpringBootTest
public class DoctorServiceTestImp {

	@InjectMocks
	private DoctorService doctorservice;
	@Mock
	private DoctorRepo repo;
	@Test
	void testAddDoctor() {
		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
	  Mockito.when(repo.save(d)).thenReturn(d);                        //save to repository
       
      assertThat(doctorservice.addDoctor(d)).isEqualTo(d);            //checks the object
	}

	@Test
	void testUpdateDoctor() throws Throwable {
		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  Optional<Doctor> d2= Optional.of(d);

	        Mockito.when(repo.findById(1)).thenReturn(d2);
	        Mockito.when(repo.save(d)).thenReturn(d);
			d.setDoctorID(1);
			d.setDoctorName("Kiran");
			d.setDoctorSpecialist("Covid");
			d.setEmail("kiran@gmail.com");
			d.setLeaveDay("Sunday");
			d.setMobile("9123456789");
			  assertThat(doctorservice.updateDoctor(d)).isEqualTo(d);
	}

	@Test
	void testGetDoctorById() throws Throwable {
		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  Optional<Doctor> d2= Optional.of(d);

	        Mockito.when(repo.findById(1)).thenReturn(d2);
	        Mockito.when(repo.save(d)).thenReturn(d);
	        assertThat(doctorservice.updateDoctor(d)).isEqualTo(d);
	}

	@Test
	void testDeletedoctorById() {
		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  Optional<Doctor> d2= Optional.of(d);
		  Mockito.when(repo.findById(1)).thenReturn(d2);
	        Mockito.when(repo.existsById(d.getDoctorID())).thenReturn(false);
	        assertFalse(repo.existsById(d.getDoctorID()));
		  
	}

	@Test
	void testDeleteDoctorById() {
		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  Optional<Doctor> d2= Optional.of(d);
		  Mockito.when(repo.findById(1)).thenReturn(d2);
	        Mockito.when(repo.existsById(d.getDoctorID())).thenReturn(false);
	        assertFalse(repo.existsById(d.getDoctorID()));
	
	}
	
	@Test
	void testGetDoctorByEmail() throws Throwable {
		Doctor d = new Doctor();
		d.setDoctorID(10);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  //Optional<Doctor> d2= Optional.of(d);

	        Mockito.when(repo.findByemail("kiran@gmail.com")).thenReturn(d);
	        Mockito.when(repo.save(d)).thenReturn(d);
	        assertThat(doctorservice.getDoctorByEmail("kiran@gmail.com")).isEqualTo(d);
	}
	
	@Test
	void testUpdateDoctorByEmail() throws Throwable {
		Doctor d = new Doctor();
		d.setDoctorID(10);
		d.setDoctorName("Kiran");
		d.setDoctorSpecialist("Covid");
		d.setEmail("kiran@gmail.com");
		d.setLeaveDay("Sunday");
		d.setMobile("9123456789");
		  Optional<Doctor> d1= Optional.of(d);

	        Mockito.when(repo.findByemail("kiran@gmail.com")).thenReturn(d);
	        Mockito.when(repo.save(d)).thenReturn(d);
			d.setDoctorID(10);
			d.setDoctorName("Kiran");
			d.setDoctorSpecialist("Covid");
			d.setEmail("kiran@gmail.com");
			d.setLeaveDay("Sunday");
			d.setMobile("9123456789");
			  assertThat(doctorservice.updateDoctorByEmail("kiran@gmail.com", d)).isEqualTo(d);
	}
	

	
	}


