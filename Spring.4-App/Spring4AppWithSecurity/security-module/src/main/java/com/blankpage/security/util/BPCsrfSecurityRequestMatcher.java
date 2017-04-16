package com.blankpage.security.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component(value="bpCsrfSecurityRequestMatcher")
public class BPCsrfSecurityRequestMatcher implements RequestMatcher {

	static final Logger logger = LoggerFactory
			.getLogger(BPCsrfSecurityRequestMatcher.class);

	
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
    private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/unprotected", null);
 
	
	public boolean matches(HttpServletRequest request) {
		logger.info("matches() : matching Request");
		
		if(allowedMethods.matcher(request.getMethod()).matches()){
            return false;
        }
		return false;
        //return !unprotectedMatcher.matches(request);
	}

}
