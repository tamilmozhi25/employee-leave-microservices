package com.FirstProject.EmployeeService.exception;

import org.springframework.security.core.userdetails.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf(csrf-> csrf.disable())
		.authorizeHttpRequests(auth->auth.requestMatchers(
				"/v3.api-docs/**",
				"/swagger-ui/**",
				"/swagger-ui.html"
				).permitAll().anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users()
	{
		UserDetails user = User.withUsername("ttm")
				.password("{noop}ttm123")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
				
	}
}