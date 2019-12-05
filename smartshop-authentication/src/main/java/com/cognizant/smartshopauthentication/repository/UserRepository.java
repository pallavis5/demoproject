package com.cognizant.smartshopauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.smartshopauthentication.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query(value = "FROM User user where user.userId=?1")
	User findByUsername(String name);
	
	@Query(value=" FROM User user join user.roleList role where role.rolename='admin'")
	List<User> adminDetails();

}
