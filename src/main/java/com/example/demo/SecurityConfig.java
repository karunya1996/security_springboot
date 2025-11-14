package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/user/**").hasRole("USER")
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/login")   // custom login page
	                .permitAll()
	            )
	            .logout(logout -> logout.permitAll());

	        return http.build();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails user1 = User.withUsername("john")
	                .password(passwordEncoder().encode("password123"))
	                .roles("USER")
	                .build();

	        UserDetails admin = User.withUsername("admin")
	                .password(passwordEncoder().encode("admin123"))
	                .roles("ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(user1, admin);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	}


