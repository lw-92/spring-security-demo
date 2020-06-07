package com.lee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 短信登录认证
 */
@Component
public class SmsAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails admin = userDetailsService.loadUserByUsername("admin");
        Collection<? extends GrantedAuthority> authorities = admin.getAuthorities();
        String username = admin.getUsername();
        SmsAuthenticationToken smsAuthenticationToken = new SmsAuthenticationToken(username, "15123917672",authorities);
        //smsAuthenticationToken.setAuthenticated(true);
        smsAuthenticationToken.setDetails(authentication.getDetails());
        return smsAuthenticationToken;
    }

    // 支持短信认证得token
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);

    }
}
