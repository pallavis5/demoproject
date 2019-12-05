package com.cognizant.smartshopauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.smartshopauthentication.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	

}
