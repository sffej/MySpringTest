/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.general;

import java.io.InputStream;

import com.blankpage.common.dto.ImageEntityDTO;



/**
 * @author mokhan
 * 
 */

public interface UploadImageService {

	public void uploadImage(InputStream image);

	public ImageEntityDTO getImage();

}
