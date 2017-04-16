package com.blankpage.security.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

@Component(value="bpHttpAuthenticationEntryPoint")
public class BPHttpAuthenticationEntryPoint implements AuthenticationEntryPoint {

	static final Logger logger = LoggerFactory
			.getLogger(BPHttpAuthenticationEntryPoint.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.info("commence() : Unauthorized access for "+request.getRequestURL().toString());
		if(request.getRequestURL().toString().endsWith(".html")){
			redirectStrategy.sendRedirect(request, response, "/login.jsp");
		}else{
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		}
	}

}
