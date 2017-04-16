package com.blankpage.security.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.blankpage.common.domain.BPUserAccount;
import com.blankpage.common.exception.BPAuthenticationException;


@Component(value = "bpAuthenticationProviderUtil")
public class BPAuthenticationProviderUtil extends
		AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private PasswordEncoder encoder;
	
	static final Logger LOGGER = LoggerFactory.getLogger(BPAuthenticationProviderUtil.class);

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		LOGGER.info("additionalAuthenticationChecks() - START");
		LOGGER.info("additionalAuthenticationChecks() - END");
	
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String password = (String) authentication.getCredentials();
		if (!StringUtils.hasText(password)) {
			LOGGER.info("retrieveUser() - Username {}: no password provided" + username);
			throw new BPAuthenticationException("Please enter password");
		}
		BPUserAccount user = BPDataBaseInitializer.getUserByUserId(username);
		if (user == null) {
			LOGGER.info("Username {} password {}: user not found" + username
					+ " : " + password);
			throw new UsernameNotFoundException("Invalid Login");
		}

		if (!encoder.matches(password, user.getPassword())) {
			LOGGER.info("Username {} password {}: invalid password " + username
					+ " : " + password);
			throw new BadCredentialsException("Invalid Login");
		}

		if (!user.getEnabled()) {
			// logger.warn("Username {}: disabled", username);
			throw new BadCredentialsException("User disabled");
		}

		final List<GrantedAuthority> auths;
		if (!user.getRoles().isEmpty()) {
			auths = AuthorityUtils.commaSeparatedStringToAuthorityList(user
					.getRolesCSV());
		} else {
			auths = AuthorityUtils.NO_AUTHORITIES;
		}

		LOGGER.info("Login successfull for user : " + username);
		return new User(username, password, user.getEnabled(), // enabled
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				auths);

	}

}
