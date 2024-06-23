package com.backendsub.domain.accidentsite.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.requestDto.AccidentSiteRequestDto;

import java.util.List;

public interface AccidentSiteRepositoryCustom {

    List<AccidentSite> findNearByLocation(double latitude, double longitude);
}
