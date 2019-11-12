package com.footwear.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.footwear.model.Authorities;
import com.footwear.model.User;
import com.footwear.service.CustomerService;
import com.footwear.service.UserService;

@Controller
public class UserController {
	 @Autowired
	 UserService userService;
	 
	 @Autowired
	 CustomerService customerService;
	
	ModelAndView mav;
	
	//Show user list
	@RequestMapping(value="/users")
	public ModelAndView getUserList() {
		//get user list from DB
		mav = new ModelAndView("user_list");
		mav.addObject("USERLIST",userService.getAllUser());
		return mav;
	}
	
	//Show the user form for new user creation
	@RequestMapping(value="/adduser",  method = RequestMethod.GET)
	public ModelAndView addUser() {
		
		//Set<Authorities> authorities = new HashSet<Authorities>();
		mav = new ModelAndView("user_form");
		mav.addObject("userObj",new User());
		mav.addObject("action_msg","Create New User");
		mav.addObject("CUSTOMERLIST",customerService.getAllCustomer());
		
		return mav;
	}
	
	
	//Process the User Form
	@RequestMapping(value="processUserForm",params="confirm", method=RequestMethod.POST)
	public ModelAndView processUserForm(@Valid @ModelAttribute("userObj") 
	User user, BindingResult br, @RequestParam("cust") int custcode,
	@RequestParam("user_role") String user_role,
	@RequestParam("confirmPassword") String confirmPassword,
	RedirectAttributes redirect) {
		ModelAndView mav =new ModelAndView("user_form");
		mav.addObject("action_msg","Edit New User");
		  User credential = userService.getUserByUsername(user.getUsername());
		  
		System.out.println(custcode +"|"+user.getPassword() +"|"+ confirmPassword);
		System.out.println(user_role);
		
		if (br.hasErrors()) {
			br.getAllErrors().forEach(System.out::println);
			 mav.addObject("selectedCustomer",customerService.getCustomer(custcode));
			 mav.addObject("CUSTOMERLIST",customerService.getAllCustomer());
			 return mav;
			 
		} else {  // if no binding error
			  //password not match, show error message.
			 if  (!user.getPassword().equals(confirmPassword)) {

			   	 mav.addObject("selectedCustomer",customerService.getCustomer(custcode));
				 mav.addObject("CUSTOMERLIST",customerService.getAllCustomer());
				 mav.addObject("message", "Password not match!");
				 return mav;
			 	}	
		
			 if (credential == null) { //registration
			   //Check if password and confirmed password  match
			   if (user.getPassword().equals(confirmPassword)) {
				   user.setCustomer(customerService.getCustomer(custcode));
					String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
					user.setPassword(encoded);
					user.setEnabled(true);
					Authorities role = new Authorities();
					role.setUser(user);
					role.setAuthority(user_role);
					user.getAuthorities().add(role);
					userService.addUser(user);
					redirect.addFlashAttribute("message","New user successfully created!");
					mav = new ModelAndView("redirect:/users");
			   } 
			 }
			 else  {  //updating
				 if  (user.getPassword().equals(confirmPassword)) { //check if password & confirmPassword match
				
					 	//credential.setCustomer(user.getCustomer());
						String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
						credential.setPassword(encoded);
						credential.setEnabled(true);
						credential.setFname(user.getFname());
						credential.setLname(user.getLname());
						
						Authorities role = new Authorities();
						role.setAuthority(user_role);
						role.setUser(credential);
						
						//userService.addUser(credential);
//					
//					User newuser = userService.getUserByUsername(credential.getUsername());
//					newuser.setCustomer(customerService.getCustomer(custcode));
//					userService.updateUser(newuser);
					
                    redirect.addFlashAttribute("message", "User successfully updated!"); //msg to be sent
                    mav = new ModelAndView("redirect:/users"); //redirect back to the user list
                    
	                }
				 
			 }
		
			 return mav;
		}
		
	}
		
		
	

	//Process the User Form, if cancel edit return to user list
	@RequestMapping(value="/processUserForm", params="cancel", method=RequestMethod.POST)
	public ModelAndView cancelEditUser(RedirectAttributes redirect) {
		redirect.addFlashAttribute("message","Cancel Editing!");
		mav = new ModelAndView("redirect:/users");
		return mav;
	}
			
	
	//Edit user
	@RequestMapping(value = "/edituser/{username:.+}/", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable String username) {
        ModelAndView mav = new ModelAndView("user_form");
        User user = userService.getUserByUsername(username);
        mav.addObject("userObj", user);
        mav.addObject("action", "edit");
        mav.addObject("action_msg","Edit New User");
        mav.addObject("selectedCustomer",user.getCustomer().getCustcode());
        mav.addObject("CUSTOMERLIST",customerService.getAllCustomer());
        return mav;
    }

	//Delete user
    @RequestMapping(value = "/deleteuser/{username:.+}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable String username,
    		RedirectAttributes redirect) {
    	userService.deleteUser(userService.getUserByUsername(username));
        redirect.addFlashAttribute("message", "User successfully removed!");
        return new ModelAndView("redirect:/users");
    }
	
}
