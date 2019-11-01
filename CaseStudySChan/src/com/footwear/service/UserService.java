package com.footwear.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import com.footwear.model.User;
import com.footwear.repository.UserRepository;



@Service("userDetailsService")
public class UserService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public void saveUser (User user) {
		userRepository.save(user);
	}
    
  //Spring Security Specific
  	@Override
  	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  		//From DB
  		User user = userRepository.findByUsername(username);  //username is the email
  		
  		//To comply with Spring Sec User
  		UserBuilder builder = null;
  		
  		if(user != null) {
  			builder = org.springframework.security.core.userdetails.User.withUsername(username);
  			builder.password(user.getPassword());
  			builder.disabled(!user.isEnabled());
  			String [] authorities = user.getAuthorities()
  					.stream().map(
  							a -> a.getAuthority()).toArray(String[]::new);
  			
  			builder.authorities(authorities);
  		}else {
  			throw new UsernameNotFoundException("User Not Found!");
  		}
  		
  		return builder.build();
  	}
    
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public boolean addUser(User user) {
        return userRepository.save(user) != null;
    }

  
    public boolean updateUser(User user) {
        return userRepository.save(user) != null;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
        //loginRepository.deleteById(login.getId());
    }

}
