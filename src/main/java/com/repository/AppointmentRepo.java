package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer>
{
	

}