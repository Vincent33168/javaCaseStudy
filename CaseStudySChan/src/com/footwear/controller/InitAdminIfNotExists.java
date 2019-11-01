package com.footwear.controller;

import com.footwear.model.Authorities;
import com.footwear.model.User;
import com.footwear.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitAdminIfNotExists {
//
//	@Autowired
//	UserService userService;


    @Autowired
    UserRepository userRepository;
    
	//Optional
	@RequestMapping("/login")
	public void initAdmin() {

		User user = userRepository.findByUsername("kun@gamil.com");

		if (user == null) {
			System.out.println("Creating admin...");
			User adminUser = new User();
			adminUser.setFname("kun"); 
			adminUser.setLname("Kun");
			adminUser.setUsername("kun@gmail.com");
			String encoded = new BCryptPasswordEncoder().encode("123456");
			adminUser.setPassword(encoded);
			adminUser.setEnabled(true);

			Authorities role = new Authorities();
			role.setUser(adminUser);
			role.setAuthority("ROLE_ADMIN");
			
			adminUser.getAuthorities().add(role);
			
			userRepository.save(adminUser);
		}
	}

}
