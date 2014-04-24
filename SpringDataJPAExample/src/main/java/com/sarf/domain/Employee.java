/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mokhan
 * 
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeId")
	private int nEmployeeId;
	@Column(name = "employeeName")
	private String strEmployeeName;

	/**
	 * @return the nEmployeeId
	 */
	public int getnEmployeeId() {
		return nEmployeeId;
	}

	/**
	 * @param nEmployeeId
	 *            the nEmployeeId to set
	 */
	public void setnEmployeeId(final int nEmployeeId) {
		this.nEmployeeId = nEmployeeId;
	}

	/**
	 * @return the strEmployeeName
	 */
	public String getStrEmployeeName() {
		return strEmployeeName;
	}

	/**
	 * @param strEmployeeName
	 *            the strEmployeeName to set
	 */
	public void setStrEmployeeName(final String strEmployeeName) {
		this.strEmployeeName = strEmployeeName;
	}

}
