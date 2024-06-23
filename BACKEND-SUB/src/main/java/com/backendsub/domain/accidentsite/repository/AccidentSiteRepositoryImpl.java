package com.backendsub.domain.accidentsite.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccidentSiteRepositoryImpl implements AccidentSiteRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AccidentSite> findNearByLocation(double latitude, double longitude, double radius) {
        return List.of();
    }
}
