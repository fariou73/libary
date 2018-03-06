package com.simbirsoft.libary.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

public class CustomAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String pw       = authentication.getCredentials().toString();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pw)) {
            throw new BadCredentialsException("Name or password is empty");
        }

        if (!"user".equals(username) || !"password".equals(pw)) {
            throw new BadCredentialsException("Name or password is incorrect");
        }
        return new UsernamePasswordAuthenticationToken(
                username, pw, AuthorityUtils.createAuthorityList("ROLE_USER"));

    }

}
