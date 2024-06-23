package com.backendsub.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;

import java.util.List;

public class AccidentSiteRepositoryImpl implements AccidentSiteRepositoryCustom{

    @Override
    public List<AccidentSite> findNearByLocation(double latitude, double longitude, double radius) {
        return List.of();
    }
}
