package com.blankpage.security.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component(value="bpHttpLogoutSuccessHandler")
public class BPHttpLogoutSuccessHandler implements LogoutSuccessHandler{

	static final Logger logger = LoggerFactory
			.getLogger(BPHttpLogoutSuccessHandler.class);
	
	public void onLogoutSuccess(HttpServletRequest arg0,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		
		 if(authentication.isAuthenticated()){
			 User user = (User) authentication.getPrincipal();
			 user.eraseCredentials();
			 logger.info("onLogoutSuccess() : User "+user.getUsername()+" logout successfully");
		 }
			
		response.setStatus(HttpServletResponse.SC_OK);
        //response.getWriter().flush();
       response.sendRedirect("login.jsp");
	}

}
