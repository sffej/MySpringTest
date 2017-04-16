/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2013 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.common.service.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * 
 * @author mokhan
 */
public class UploadUtil {

	public static byte[] getImage(final InputStream inputStream) {
		byte images[] = null;
		try {
			// final BufferedImage image = ImageIO.read(new File(
			// "d:\\images\\peacock.jpg"));

			final BufferedImage image = ImageIO.read(inputStream);

			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpeg", baos);

			// ImageIO.write(image, "jpeg", new File("D:\\images.jpeg"));
			images = baos.toByteArray();

		} catch (final Exception e) {
			e.printStackTrace();

		}
		return images;
	}

}
