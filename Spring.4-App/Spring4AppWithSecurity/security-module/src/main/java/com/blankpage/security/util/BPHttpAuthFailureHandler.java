package com.blankpage.security.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component(value="bpHttpAuthFailureHandler")
public class BPHttpAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	static final Logger logger = LoggerFactory
			.getLogger(BPHttpAuthFailureHandler.class);
	
	 @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	            AuthenticationException exception) throws IOException, ServletException {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        logger.info("onAuthenticationFailure() : Unauthorized access");
	        PrintWriter writer = response.getWriter();
	        writer.write(exception.getMessage());
	        writer.flush();
	    }
}
