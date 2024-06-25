package com.backendsub.domain.schoolzone.service;

import com.backendsub.domain.schoolzone.domain.SchoolZone;
import com.backendsub.domain.schoolzone.repository.SchoolZoneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class SchoolZoneService {

    private final SchoolZoneRepository schoolZoneRepository;

    @Transactional
    public List<SchoolZone> findSchoolZoneNearByLocation(double latitude, double longitude) {
        List<SchoolZone> responses = schoolZoneRepository.findNearByLocation(latitude, longitude);
        return responses;
    }
}
