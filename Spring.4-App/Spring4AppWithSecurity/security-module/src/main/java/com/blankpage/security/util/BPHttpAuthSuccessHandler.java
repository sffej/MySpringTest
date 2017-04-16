package com.blankpage.security.util;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.blankpage.common.domain.BPUserAccount;

@Component(value = "bpHttpAuthSuccessHandler")
public class BPHttpAuthSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	static final Logger logger = LoggerFactory
			.getLogger(BPHttpAuthSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		final SavedRequest savedRequest = requestCache.getRequest(request,
				response);

		String targetUrl = "/pages/index.jsp";
		response.setStatus(HttpServletResponse.SC_OK);
		User user = (User) authentication.getPrincipal();

		String userName = user.getUsername();
		// BPUserAccount bpUserAccount =
		// BPDataBaseInitializer.getUserByUserId(userName);

		Collection<GrantedAuthority> role = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : role) {
			/*
			 * if
			 * ("ROLE_ADMIN".equalsIgnoreCase(grantedAuthority.getAuthority()))
			 * { targetUrl = "/admin/adminDashboard.html"; }
			 */
		}

		response.addHeader("REMOTE_USER", user.getUsername());
		logger.info(user.getUsername() + "  is connected successfully ");
		redirectStrategy.sendRedirect(request, response, targetUrl);
		return;

	}

	protected void clearAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRequestCache(final RequestCache requestCache) {
		this.requestCache = requestCache;
	}
}
