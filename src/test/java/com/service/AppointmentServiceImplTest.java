package com.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Appointment;

import com.repository.AppointmentRepo;


@SpringBootTest
class AppointmentServiceImplTest {
	
	@Autowired
	
	AppointmentService appointmentservice;
	
	@MockBean
	AppointmentRepo repo;

	@Test
	void testAddAppointment() {
		Appointment a=new Appointment();
		a.setAid(1);
		a.setDate("13-08-22");
		a.setTime("09:00");
		Mockito.when(repo.save(a)).thenReturn(a);
		assertThat(appointmentservice.addAppointment(a)).isEqualTo(a);
		
	}
	@Test
	void testAddAppointments() {
		Appointment a1=new Appointment();
		a1.setAid(1);
		a1.setDate("13-08-22");
		a1.setTime("09:00");
		
		Appointment a2=new Appointment();
		a2.setAid(2);
		a2.setDate("14-08-22");
		a2.setTime("10:00");
		List<Appointment> appointmentList= new ArrayList<>();
		appointmentList.add(a1);
		appointmentList.add(a2);
		 
		
		Mockito.when(repo.findAll()).thenReturn(appointmentList);
		assertThat(appointmentservice.addAppointments(appointmentList)).isEqualTo(appointmentList);
	}

		
	
@Test void testGetAppointments()
{
	Appointment a1=new Appointment();
	a1.setAid(1);
	a1.setDate("13-08-22");
	a1.setTime("09:00");
	
	Appointment a2=new Appointment();
	a2.setAid(2);
	a2.setDate("14-08-22");
	a2.setTime("10:00");
	List<Appointment> appointmentList= new ArrayList<>();
	appointmentList.add(a1);
	appointmentList.add(a2);
	Mockito.when(repo.findAll()).thenReturn(appointmentList);
	assertThat(appointmentservice.getAppointments()).isEqualTo(appointmentList);
}
	
	 
	 
  
  @Test 
  
	  void testGetAppointmentById() throws Throwable {
			
		  Appointment a1=new Appointment(); 
		  a1.setAid(1); 
		  a1.setDate("15-03-22");
		  a1.setTime("11:00");
		 
		Optional<Appointment> a2=Optional.of(a1);
		
		Mockito.when(repo.findById(1)).thenReturn(a2);
		
		assertThat(appointmentservice.getAppointmentById(1)).isEqualTo(a1);
	  
  }
  
	
	 @Test 
	 void testDeleteAppointmentById() {
	 
		 Appointment a1 = new Appointment();
		 a1.setAid(1);
			a1.setDate("13-08-22");
			a1.setTime("09:00");
		 
		 Optional<Appointment> a2= Optional.of(a1);
		 Mockito.when(repo.findById(1)).thenReturn(a2);
		 Mockito.when(repo.existsById(a1.getAid())).thenReturn(false);
		 assertFalse(repo.existsById(a1.getAid()));

}




	 
  @Test 
  void testDeleteAppointment() 
  {
	  Appointment a1=new Appointment();
		a1.setAid(1);
		a1.setDate("13-08-22");
		a1.setTime("09:00");
		Optional<Appointment> a2=Optional.of(a1);
		Mockito.when(repo.findById(1)).thenReturn(a2);
		 Mockito.when(repo.existsById(a1.getAid())).thenReturn(false);
		 assertFalse(repo.existsById(a1.getAid()));
		
	  
  }
  @Test 
  void testUpdateAppointment() throws Throwable
  {
  
 
	  Appointment a1=new Appointment();
		a1.setAid(1);
		a1.setDate("13-08-22");
		a1.setTime("09:00");
		
		Optional<Appointment> a2=Optional.of(a1);
		Mockito.when(repo.findById(1)).thenReturn(a2);
		Mockito.when(repo.save(a1)).thenReturn(a1);
		a1.setDate("16-08-22");
		a1.setTime("12:00");
		
		assertThat(appointmentservice.updateAppointment(a1)).isEqualTo(a1);
		
	 
 }
  }
 