package com.backendsub.domain.schoolzone.repository;

import com.backendsub.domain.schoolzone.domain.SchoolZone;

import java.util.List;

public interface SchoolZoneRepositoryCustom {

    List<SchoolZone> findNearByLocation(double latitude, double longitude);
}
