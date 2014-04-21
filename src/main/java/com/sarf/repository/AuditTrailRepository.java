package com.sarf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarf.domain.AuditTrail;

@Repository
public interface AuditTrailRepository extends JpaRepository<AuditTrail,Integer>{

}
