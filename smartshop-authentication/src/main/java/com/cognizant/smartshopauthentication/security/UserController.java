package com.cognizant.smartshopauthentication.security;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshopauthentication.model.User;
import com.cognizant.smartshopauthentication.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/{name}")
	public UserDetails testFindByUsername(@PathVariable("name") String name) {
		return appUserDetailsService.loadUserByUsername(name);

	}

	@PostMapping("/user")
	public String signupUser(@RequestBody @Valid User user) {
		return appUserDetailsService.signupUser(user);

	}

	@PostMapping("/admin")
	public String signupAdmin(@RequestBody @Valid User user) {
		return appUserDetailsService.signupAdmin(user);

	}

	@GetMapping("/admin")
	public List<User> adminDetails() {
		return userRepository.adminDetails();
	}

	@PutMapping("")
	public void response(@RequestBody User user) {
		appUserDetailsService.response(user);

	}
}
