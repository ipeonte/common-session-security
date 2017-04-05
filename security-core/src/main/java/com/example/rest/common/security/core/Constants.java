package com.example.rest.common.security.core;

/**
 * Core Security constants constants
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
public class Constants {

    // Cookie name that being set by authentication server
    public static final String COOKIE_SESSION_NAME = "SSO_SESSION";

    // Default cookie domain that being set by authentication server
    public static final String DEF_COOKIE_DOMAIN = "localhost";

    // Default cookie path that was set by authentication server
    public static final String DEF_COOKIE_PATH = "/";
    
    // Session parameter name that that was set by authentication server. It holds user name used during login
    public static final String USER_NAME_KEY = "userName";

    // Redis namespace that used keep all security session. 
    // The complete namespace will be security.session.<CUSTOM_SESSION_NAMESPACE>.sessions
    public static final String SESSION_NAMESPACE = "example";
}
