/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.webservice;

import java.net.URI;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blankpage.general.UploadImageService;
import com.blankpage.common.dto.ImageEntityDTO;



/**
 * @author mokhan
 * 
 */
@Service
@Transactional
public class UploadImageRestImpl implements UploadImageRest {

	Logger LOGGER = LoggerFactory.getLogger(UploadImageRestImpl.class);
	
	@Autowired
	private UploadImageService uploadImageService;

	public Response uploadImage(final MultipartBody multipart) {
		LOGGER.info("uploadImage() - START");
		try {
			this.uploadImageService.uploadImage(multipart.getRootAttachment()
					.getDataHandler().getInputStream());
			
			LOGGER.info("uploadImage() - END");
			
			return Response.temporaryRedirect(new URI("/blankpage/index.jsp"))
					.build();

		} catch (final Exception e) {
			e.printStackTrace();
			return Response
					.created(
							URI.create("/" + String.valueOf(UUID.randomUUID())))
					.entity("Failed to upload image").build();
		}
		

	}

	/** {@inheritDoc} */
	public byte[] getImage() {
		LOGGER.info("getImage() - START");
		final ImageEntityDTO imageDTO = this.uploadImageService.getImage();
		LOGGER.info("getImage() - END");
		return imageDTO.getImage();
	}
}
