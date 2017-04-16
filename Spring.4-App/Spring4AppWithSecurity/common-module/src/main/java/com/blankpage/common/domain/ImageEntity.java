/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.common.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * @author mokhan
 * 
 */
@Entity
@Table(name = "ImageEntity")
public class ImageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "imageId")
	private int nImageId;

	@Lob
	@Column(name = "image")
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
