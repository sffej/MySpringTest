/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.general;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blankpage.common.domain.ImageEntity;
import com.blankpage.common.dto.ImageEntityDTO;
import com.blankpage.common.repository.ImageEntityRepository;
import com.blankpage.common.service.util.MapperUtil;
import com.blankpage.common.service.util.UploadUtil;


/**
 * @author mokhan
 * 
 */
@Service("uploadImageService")
@Transactional
public class UploadImageServiceImpl implements UploadImageService {

	@Autowired
	ImageEntityRepository imageEntityRepository;

	private Mapper mapper = MapperUtil.getMapper();

	/** {@inheritDoc} */
	public void uploadImage(final InputStream iSImage) {
		final ImageEntity e = new ImageEntity();
		final byte[] image = UploadUtil.getImage(iSImage);
		e.setImage(image);
		this.imageEntityRepository.saveAndFlush(e);
	}

	/** {@inheritDoc} */
	public ImageEntityDTO getImage() {
		ImageEntityDTO imageEntityDto = new ImageEntityDTO();
		final List<ImageEntity> imageEntityList = this.imageEntityRepository
				.findLatestImage(new PageRequest(0, 1));
		if (imageEntityList != null && imageEntityList.size() > 0) {

			imageEntityDto = mapper.map(imageEntityList.get(0),
					ImageEntityDTO.class);
		}
		return imageEntityDto;

	}
	
	@PostConstruct
	public void init(){
		System.out.println("********SARF*********");
	}
	

}
