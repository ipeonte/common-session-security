package com.example.rest.common.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * WebSecurityConfig Initializer
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
    	super(WebSecurityConfig.class);
    }
}
