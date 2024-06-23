package com.backendsub.domain.accidentsite.repository;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.model.QAccidentSite;
import com.backendsub.domain.accidentsite.requestDto.AccidentSiteRequestDto;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccidentSiteRepositoryImpl implements AccidentSiteRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    private QAccidentSite accidentSite = QAccidentSite.accidentSite;

    @Override
    public List<AccidentSite> findNearByLocation(double latitude, double longitude) {
        return queryFactory
                .selectFrom(accidentSite)
                .where(
                        Expressions.booleanTemplate(
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3})) <= {4}",
                                longitude, latitude,
                                accidentSite.longitude, accidentSite.latitude,
                                10000
                        )
                )
                .orderBy(
                        Expressions.numberTemplate(
                                Double.class,
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3}))",
                                longitude, latitude,
                                accidentSite.longitude, accidentSite.latitude
                        ).asc()
                )
                .limit(30)
                .fetch();
    }
}
