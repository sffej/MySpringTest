/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.dto;

import java.io.Serializable;

/**
 * @author mokhan
 *
 */
public class EmployeeDTO implements Serializable{
	private int nEmployeeId;
	private String strEmployeeName;
	public int getnEmployeeId() {
		return nEmployeeId;
	}
	public void setnEmployeeId(int nEmployeeId) {
		this.nEmployeeId = nEmployeeId;
	}
	public String getStrEmployeeName() {
		return strEmployeeName;
	}
	public void setStrEmployeeName(String strEmployeeName) {
		this.strEmployeeName = strEmployeeName;
	}
	
	
	

}
