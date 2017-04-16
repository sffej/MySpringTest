package com.blankpage.security.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.blankpage.common.domain.BPRole;
import com.blankpage.common.domain.BPUserAccount;

import javax.annotation.PostConstruct;

@Component
public class BPDataBaseInitializer {

	@Autowired
	private PasswordEncoder encoder;

	static final Logger LOGGER = LoggerFactory
			.getLogger(BPDataBaseInitializer.class);

	static final HashMap<String, BPUserAccount> userMap = new HashMap<String, BPUserAccount>();

	@PostConstruct
	public void init() {
		String demoPassword = encoder.encode("pass");
		LOGGER.info("init() : Admin password : {}",demoPassword);
		

		LOGGER.info("init() : Role created");
		BPRole adminRole = new BPRole("ROLE_ADMIN");
		if (adminRole != null) {
			LOGGER.info("init() : Roles ["+adminRole.getId() + "]");
		} 
		
		List<BPRole> bpRoleList = new ArrayList<BPRole>();
		bpRoleList.add(adminRole);
		
		BPUserAccount bpUserAccount = new BPUserAccount();
		
		// Admin
		bpUserAccount.setFirstname("Admin");
		bpUserAccount.setLastname("Admin");
		bpUserAccount.setPassword(demoPassword);
		bpUserAccount.setbPRoles(bpRoleList);
		bpUserAccount.setUserId("admin");
		// simulate account activation
		bpUserAccount.setEnabled(true);
	
		userMap.put("admin", bpUserAccount);
	}
	
	
	public static BPUserAccount getUserByUserId(String userId){
		return userMap.get(userId);
	}
	
	
}
