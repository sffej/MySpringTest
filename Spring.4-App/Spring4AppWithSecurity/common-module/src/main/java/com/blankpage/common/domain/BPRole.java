package com.blankpage.common.domain;

import java.util.UUID;

public class BPRole {

	private String id;

	private String rolename;

	public BPRole() {
	}

	public BPRole(String name) {
		this.rolename = name;
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
