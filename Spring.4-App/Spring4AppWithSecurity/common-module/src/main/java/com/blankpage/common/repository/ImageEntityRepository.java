/*
 * Amadeus Confidential Information:
 * Unauthorized use and disclosure strictly forbidden.
 * @1998-2012 - Amadeus s.a.s - All Rights Reserved.
 */
package com.blankpage.common.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blankpage.common.domain.ImageEntity;



/**
 * @author mokhan
 * 
 */
@Repository
public interface ImageEntityRepository extends
		JpaRepository<ImageEntity, Integer> {
	@Query("select e from ImageEntity e order by e.nImageId DESC ")
	public List<ImageEntity> findLatestImage(Pageable pageable);
}
