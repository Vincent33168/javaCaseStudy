package com.footwear.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("com.footwear")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	public void configure(WebSecurity web){
		web
		.ignoring()
		.antMatchers("/js/**", "/images/**", "/css/**", "/resources/**", "/scripts/**");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/home/**","/MEN**","/product/**","/aboutus/**","/contactus/**","/login","/logout").permitAll();
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.authorizeRequests()
		  .and()
          .formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll()
			.and()
			.logout().logoutSuccessUrl("/home").permitAll()
			.and()
			.csrf().disable();	
	
//		
//			.and()
//			.formLogin().loginPage("/login").loginProcessingUrl("/loginAction").defaultSuccessUrl("/", false).permitAll()
//			.and()
//			.logout().logoutSuccessUrl("/login").permitAll()
//			.and()
//			.csrf().disable();	
	}
}
