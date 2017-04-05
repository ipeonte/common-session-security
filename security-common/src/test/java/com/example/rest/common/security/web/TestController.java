package com.example.rest.common.security.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.common.security.TestConstants;
import com.example.rest.common.security.core.Constants;

/**
 * Test Controller for Common Security Layer test
 * 
 * @author Igor Peonte
 */
@RestController
public class TestController {

	@RequestMapping(TestConstants.TEST_URL)
	public String userInfo(Authentication authentication, HttpServletRequest req) {
		// Insert user name was used from login from standard http session
		String message = Constants.USER_NAME_KEY + ":" + req.getSession(false).getAttribute(Constants.USER_NAME_KEY).toString() + "|";

		if (authentication != null) {
			// Insert user name was used from login from authentication object
			message += "authenticationName:" + authentication.getName() + "|roles:";
			String roles = "";
			for (GrantedAuthority authority : authentication.getAuthorities())
				roles += "," + authority.getAuthority();

			message += roles.substring(1);
		}

		return message + "|sessionId:" + req.getSession(false).getId();
	}
}
