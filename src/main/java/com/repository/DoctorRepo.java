package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

	Doctor findByemail(String email);
 	
}
