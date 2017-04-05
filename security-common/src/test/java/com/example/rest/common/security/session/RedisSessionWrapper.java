package com.example.rest.common.security.session;


import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.session.ExpiringSession;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

import com.example.rest.common.security.TestConstants;
import com.example.rest.common.security.core.Constants;

/**
 * RedisSessionWrapper
 * 
 * @see https://github.com/spring-projects/spring-session/issues/79
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 * @param <S>
 *            Session Type
 */
public class RedisSessionWrapper<S extends ExpiringSession> {

	private SessionRepository<S> repository;

	@SuppressWarnings("unchecked")
	public RedisSessionWrapper(RedisOperationsSessionRepository repository) {
		this.repository = (SessionRepository<S>) repository;
	}

	public S create(SecurityContext context) {
		S s = repository.createSession();
		// Inject test attributes
		s.setAttribute(Constants.USER_NAME_KEY, TestConstants.TEST_USER_NAME);
		s.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);
		repository.save(s);

		return s;
	}
}
