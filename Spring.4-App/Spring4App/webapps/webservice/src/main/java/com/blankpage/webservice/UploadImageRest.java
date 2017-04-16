/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

/**
 * @author mokhan
 * 
 */
@Path("/uploadimage-service/")
@Produces(MediaType.APPLICATION_JSON)
public interface UploadImageRest {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("uploadImage")
	public Response uploadImage(@Multipart("file") MultipartBody p_attachment);

	@GET
	@Path("getLatestImage")
	public byte[] getImage();

}
