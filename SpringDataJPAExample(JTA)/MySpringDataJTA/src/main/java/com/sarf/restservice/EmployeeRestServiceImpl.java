/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.restservice;

import java.io.File;
import java.util.List;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarf.domain.AuditTrail;
import com.sarf.dto.EmployeeDTO;
import com.sarf.dto.ResponseDTO;
import com.sarf.service.EmployeeService;

/**
 * @author mokhan
 * 
 */
@Service
@Transactional
public class EmployeeRestServiceImpl implements EmployeeRestService {

	@Autowired
	private EmployeeService employeeService;

	public void addEmployee(final String employeeName) {
		this.employeeService.addEmployee(employeeName);
	}

	/** {@inheritDoc} */
	public Response getEmployee(final Integer nEmplId) {
		final EmployeeDTO employeeDTO = this.employeeService
				.getEmployee(nEmplId);
		return Response.ok(employeeDTO).build();

	} 

	public Response getEmployees() {
		final List<EmployeeDTO> listEmployeeDTO = this.employeeService
				.getEmployees();
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode("1000");
		responseDTO.setList(listEmployeeDTO);
		ResponseBuilder rb = Response.ok(responseDTO);
		CacheControl cc = new CacheControl();
		cc.setMaxAge(300);
		cc.setPrivate(true);
		cc.setNoStore(false);
		rb.cacheControl(cc);
		return rb.build();
	}

	public List<EmployeeDTO> getEmployeesByName(final String strEmployeeName) {
		final List<EmployeeDTO> listEmployeeDTO = this.employeeService
				.getEmployeesByName(strEmployeeName);
		return listEmployeeDTO;
	}

	public Response deleteEmployee(final String strEmplId) {
		this.employeeService.deleteEmployee(strEmplId);
		return Response.ok(Status.OK).build();
	}

	public Response download() {
		final File file = new File("D:/CMG/Technology.txt");
		return Response
				.ok(file, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition",
						"attachment; filename =" + file.getName()).build();
	}

	public List<AuditTrail> getAuditTrail() {
		List<AuditTrail> auditTrailList = this.employeeService.getAuditTrail();
		return auditTrailList;
	}

	public Response getEmployeeByPage(String page) {
		return Response.ok(this.employeeService.getEmployeeByPage(page)).build();
	}
}
