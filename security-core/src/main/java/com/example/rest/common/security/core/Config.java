package com.example.rest.common.security.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Configuration class for RedisHttpSession Define special namespace to store
 * session data
 *
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = Constants.SESSION_NAMESPACE)
public class Config {

	@Value("${cookie.domain:" + Constants.DEF_COOKIE_DOMAIN + "}")
	private String cookieDomain;

	@Value("${cookie.path:" + Constants.DEF_COOKIE_PATH + "}")
	private String cookiePath;

	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer s = new DefaultCookieSerializer();
		s.setCookieName(Constants.COOKIE_SESSION_NAME);
		s.setDomainName(cookieDomain);
		s.setCookiePath(cookiePath);

		return s;
	}
	
}
