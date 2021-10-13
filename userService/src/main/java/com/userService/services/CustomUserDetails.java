package com.userService.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		if (userName.equals("admin")) {
			return new User("admin", "admin", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found !!");
		}
	}

}
