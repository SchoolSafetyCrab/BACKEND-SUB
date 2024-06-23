package com.backendsub.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;

import java.util.List;

public interface AccidentSiteRepositoryCustom {

    List<AccidentSite> findNearByLocation(double latitude, double longitude, double radius);
}
