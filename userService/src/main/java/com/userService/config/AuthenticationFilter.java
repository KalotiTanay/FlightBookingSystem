package com.userService.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.userService.services.CustomUserDetails;
import com.userService.util.JwtUtil;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetails customUserDetails;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// 1. get JWT Header
		// 2. Check Bearer
		// 3. validate
		
		String requestTokenString = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		
		// Checking null and format of JWT Header
		if (requestTokenString != null && requestTokenString.startsWith("Bearer ")) {
			
			jwtToken = requestTokenString.substring(7);
			
			try {
				
				username = this.jwtUtil.extractUsername(jwtToken);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			UserDetails userDetails = this.customUserDetails.loadUserByUsername(username);
			//Security Check
			System.out.println(username);
			System.out.println(SecurityContextHolder.getContext().getAuthentication());
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			else {System.out.println("Token validation incomplete.....");}
			
		}
		
		filterChain.doFilter(request, response);
	}	
}
