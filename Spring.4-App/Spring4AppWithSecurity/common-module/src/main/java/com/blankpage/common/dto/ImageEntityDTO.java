/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.common.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mokhan
 * 
 */
@XmlRootElement(name = "Image")
public class ImageEntityDTO {
	private int nImageId;
	private byte[] image;

	public int getnImageId() {
		return nImageId;
	}

	public void setnImageId(final int p_nImageId) {
		nImageId = p_nImageId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(final byte[] p_image) {
		image = p_image;
	}

}
