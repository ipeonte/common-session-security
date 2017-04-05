package com.example.rest.common.security;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration for each Rest Web Service that using this common security library.
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
	
		http
	
		////////////////////////////////////////////////////////////////////////////
		// All URLs that required anonymous access needs to be added before authorization check.
		// For example to let anonymous user /login uncomment line below:
		// .authorizeRequests().antMatchers("GET", "/login").anonymous().and()
	
		//////////////////////////////////////////////////////////////////////////////////
		// 		Main security Gate. Deny All -> Allow Authenticated only	//
		//////////////////////////////////////////////////////////////////////////////////
			.authorizeRequests()
				.anyRequest().authenticated();
	
		////////////////////////////////////////////////////////////////////////////
		// Authorized section.
		//
		// URLs that required special role(s) can be added after authentication process.
		// For example to protect all /admin/* resources with special role uncomment line below
		// .and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
	
		//@formatter:on
    }

}
