package com.backendsub.domain.schoolzone.repository;

import com.backendsub.domain.schoolzone.domain.SchoolZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolZoneRepository extends JpaRepository<SchoolZone, Long>, SchoolZoneRepositoryCustom {
}
