package com.cognizant.smartshopauthentication.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.smartshopauthentication.model.Role;
import com.cognizant.smartshopauthentication.model.User;
import com.cognizant.smartshopauthentication.repository.RoleRepository;
import com.cognizant.smartshopauthentication.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Start");
		User user = userRepository.findByUsername(username);
		LOGGER.debug("user:", user);
		LOGGER.debug(user.getStatus());

		if (user == null) {
			throw new UsernameNotFoundException("User not present");
		} else if (user.getStatus().equals("P")) {
			throw new UsernameNotFoundException("Registration not approved");
		} else {
			AppUser appUser = new AppUser(user);
			LOGGER.debug("authorities:", appUser.getAuthorities());
			return appUser;
		}
	}

	public String signupUser(User user) {
		User user1 = userRepository.findByUsername(user.getUserId());
		if (user1 != null) {
			// throw new UserAlreadyExistsException();
			return "false";

		} else {
			Set<Role> roleList = new HashSet<>();
			roleList.add(roleRepository.findById(1).get());
			user.setRoleList(roleList);
			user.setUserType("U");
			user.setStatus("A");
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			return "true";
		}
	}

	public String signupAdmin(User user) {
		User user1 = userRepository.findByUsername(user.getUserId());
		if (user1 != null) {
			// throw new UserAlreadyExistsException();
			return "false";

		} else {
			Set<Role> roleList = new HashSet<>();
			roleList.add(roleRepository.findById(2).get());
			user.setRoleList(roleList);
			user.setUserType("A");
			user.setStatus("P");
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			return "true";
		}
	}

	public void response(User user) {
		// User user1=userRepository.findByUsername(user.getUserId());
		userRepository.save(user);
	}

}
