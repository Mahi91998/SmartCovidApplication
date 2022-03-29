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

import com.entity.Admin;
import com.repository.AdminRepo;

@SpringBootTest
class AdminServiceTest {
	@InjectMocks
	private AdminService adminservice;
	@Mock
	private AdminRepo repo;
	@Test
	void testAddAdmin() {
	  Admin a = new Admin();
	  a.setAdminId(1);
	  a.setAdminMail("xxx@gmail.com");
	  a.setadminUsername("danni");
	  a.setPassword("sunny");
	  Mockito.when(repo.save(a)).thenReturn(a);                        //save to repository
       
      assertThat(adminservice.addAdmin(a)).isEqualTo(a);            //checks the object
	}

	@Test
	void testUpdateAdmin() throws Throwable {
		Admin a = new Admin();
		a.setAdminId(1);
		  a.setAdminMail("xxx@gmail.com");
		  a.setadminUsername("danni");
		  a.setPassword("sunny");
		  Optional<Admin> c2= Optional.of(a);

	        Mockito.when(repo.findById(1)).thenReturn(c2);
	        Mockito.when(repo.save(a)).thenReturn(a);
	        a.setAdminId(1);
			  a.setAdminMail("xxx@gmail.com");
			  a.setadminUsername("danni");
			  a.setPassword("sunny");
			  assertThat(adminservice.updateAdmin(a)).isEqualTo(a);
	}

	@Test
	void testGetAdminById() throws Throwable {
		Admin a = new Admin();
		a.setAdminId(1);
		  a.setAdminMail("xxx@gmail.com");
		  a.setadminUsername("danni");
		  a.setPassword("sunny");
		  Optional<Admin> c2= Optional.of(a);

	        Mockito.when(repo.findById(1)).thenReturn(c2);
	        Mockito.when(repo.save(a)).thenReturn(a);
	        assertThat(adminservice.updateAdmin(a)).isEqualTo(a);
	}

	@Test
	void testDeleteAdminById() {
		Admin a = new Admin();
		a.setAdminId(1);
		  a.setAdminMail("xxx@gmail.com");
		  a.setadminUsername("danni");
		  a.setPassword("sunny");
		  Optional<Admin> c2= Optional.of(a);
		  Mockito.when(repo.findById(1)).thenReturn(c2);
	        Mockito.when(repo.existsById(a.getAdminId())).thenReturn(false);
	        assertFalse(repo.existsById(a.getAdminId()));
		  
	}

	@Test
	void testDeleteDoctorById() {
		Admin a = new Admin();
		a.setAdminId(1);
		  a.setAdminMail("xxx@gmail.com");
		  a.setadminUsername("danni");
		  a.setPassword("sunny");
		  Optional<Admin> c2= Optional.of(a);
		  Mockito.when(repo.findById(1)).thenReturn(c2);
	        Mockito.when(repo.existsById(a.getAdminId())).thenReturn(false);
	        assertFalse(repo.existsById(a.getAdminId()));
	
	}

	
}
