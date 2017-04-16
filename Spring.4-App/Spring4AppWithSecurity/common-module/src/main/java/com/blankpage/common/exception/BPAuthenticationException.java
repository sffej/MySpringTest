package com.blankpage.common.exception;

import org.springframework.security.core.AuthenticationException;

public class BPAuthenticationException extends AuthenticationException {

	
	public BPAuthenticationException(String messsage)
	{
		super(messsage);
	}
}
