package com.blankpage.common.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class BPUserAccount {

	private String id;

	private String userId;
	private String password;
	private String firstname;
	private String middlename;
	private String lastname;
	private String status;
	private Boolean enabled;

	private List<BPRole> bPRoles = new ArrayList<BPRole>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public List<BPRole> getbPRoles() {
		return bPRoles;
	}

	public void setbPRoles(List<BPRole> bPRoles) {
		this.bPRoles = bPRoles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<BPRole> getRoles() {
		return bPRoles;
	}

	public void addRole(BPRole bPRole) {
		this.bPRoles.add(bPRole);
	}

	public void removeRole(BPRole bPRole) {
		// use iterator to avoid java.util.ConcurrentModificationException with
		// foreach
		for (Iterator<BPRole> iter = this.bPRoles.iterator(); iter.hasNext();) {
			if (iter.next().equals(bPRole))
				iter.remove();
		}
	}

	public String getRolesCSV() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<BPRole> iter = this.bPRoles.iterator(); iter.hasNext();) {
			sb.append(iter.next().getRolename());
			if (iter.hasNext()) {
				sb.append(',');
			}
		}
		return sb.toString();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BPUserAccount)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		BPUserAccount rhs = (BPUserAccount) obj;
		return new EqualsBuilder().append(userId, rhs.userId).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(userId).append(userId).toHashCode();
	}
}
