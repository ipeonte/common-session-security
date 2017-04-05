package com.example.rest.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.ExpiringSession;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.SessionRepositoryFilter;

import com.example.rest.common.security.core.Constants;
import com.example.rest.common.security.session.SessionCookieFilter;

/**
 * AutoConfiguration file for shared library
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@Configuration
@ComponentScan("com.example.rest.common.security")
public class AutoConfiguration {
    
    @Autowired
    CookieSerializer serializer;
    
    /**
     * Switch into cookie based strategy
     * 
     * @param sessionRepository
     * @return
     */
    @Bean
    public <S extends ExpiringSession> SessionRepositoryFilter<? extends ExpiringSession> springSessionRepositoryFilter(
	    SessionRepository<S> sessionRepository) {
	return new SessionCookieFilter<S>(
		sessionRepository, Constants.COOKIE_SESSION_NAME, serializer);
    }
}
