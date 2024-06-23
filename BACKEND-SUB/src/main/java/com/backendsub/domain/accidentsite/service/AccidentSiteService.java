package com.backendsub.domain.accidentsite.service;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.repository.AccidentSiteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AccidentSiteService {

    private final AccidentSiteRepository accidentSiteRepository;

    @Transactional
    public List<AccidentSite> findNearByLocation(double latitude, double longitude){
        System.out.println(latitude+" "+longitude);
        List<AccidentSite> response = accidentSiteRepository.findNearByLocation(latitude, longitude);
        return response;
    }
}
