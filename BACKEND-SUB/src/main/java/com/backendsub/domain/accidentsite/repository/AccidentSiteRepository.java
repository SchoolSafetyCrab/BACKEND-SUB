package com.backendsub.domain.accidentsite.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentSiteRepository extends JpaRepository<AccidentSite, Long>, AccidentSiteRepositoryCustom {

}
