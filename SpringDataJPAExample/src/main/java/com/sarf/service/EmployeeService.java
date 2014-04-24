/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.service;

import java.util.List;

import com.sarf.domain.AuditTrail;
import com.sarf.dto.EmployeeDTO;
import com.sarf.dto.ResponseDTO;

/**
 * @author mokhan
 * 
 */

public interface EmployeeService {
	public void addEmployee(String emolpyeeName);

	public EmployeeDTO getEmployee(Integer nEmplId);

	public List<EmployeeDTO> getEmployees();

	public List<EmployeeDTO> getEmployeesByName(String strEmployeeName);

	public void deleteEmployee(String strEmplId);
	
	public List<AuditTrail> getAuditTrail(); 
	public ResponseDTO getEmployeeByPage(String page);
	
}
