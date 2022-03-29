package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> 
{
	

	

	
	
	
	
	
	
	
	
	
//	AdminEntity findByadminUsername(String adminUsername);
//	@Query("Select a from AdminEntity a  where a.adminMail=?1  order by a.adminUsername")
//	List<AdminEntity> findByAdminMailSorted(String adminMail);
//	
}
