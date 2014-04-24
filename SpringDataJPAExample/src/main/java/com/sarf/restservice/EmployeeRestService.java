/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.sarf.restservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sarf.domain.AuditTrail;
import com.sarf.dto.EmployeeDTO;

/**
 * @author mokhan
 * 
 */
@Path("/employee-service/")
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeRestService {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("addEmployee")
	public void addEmployee(@FormParam("employeeName") String employeeName);

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getEmployee/{emplId}")
	public Response getEmployee(@PathParam("emplId") Integer nEmplId);

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getEmployees")
	public Response getEmployees();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("getEmployeesByName/{strEmployeeName}")
	public List<EmployeeDTO> getEmployeesByName(
			@PathParam("strEmployeeName") String strEmployeeName);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("deleteEmployee/{emplId}")
	public Response deleteEmployee(@PathParam("emplId") String strEmplId);

	@GET
	@Produces(MediaType.MEDIA_TYPE_WILDCARD)
	@Path("download")
	public Response download();
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("get_audit_trail")
	public List<AuditTrail> getAuditTrail();

	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("get_employee_by_page/{page}")
	public Response getEmployeeByPage(@PathParam("page") String page);


}
