package com.cognizant.smartshopservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshopservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(value = "FROM User user where user.userId=?1")
	User findByUsername(@Param(value = "name") String name);

	@Query(value = " FROM User user join user.roleList role where role.rolename='admin'")
	List<User> adminDetails();

	User findByContact(String contact);
}
