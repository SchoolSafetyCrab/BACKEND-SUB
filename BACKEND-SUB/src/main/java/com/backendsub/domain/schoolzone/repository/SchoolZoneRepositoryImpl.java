package com.backendsub.domain.schoolzone.repository;

import com.backendsub.domain.schoolzone.domain.QSchoolZone;
import com.backendsub.domain.schoolzone.domain.SchoolZone;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SchoolZoneRepositoryImpl implements SchoolZoneRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private QSchoolZone schoolZone = QSchoolZone.schoolZone;

    @Override
    public List<SchoolZone> findNearByLocation(double latitude, double longitude) {
        return queryFactory
                .selectFrom(schoolZone)
                .where(
                        Expressions.booleanTemplate(
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3})) <= {4}",
                                longitude, latitude,
                                schoolZone.longitude, schoolZone.latitude,
                                10000
                        )
                ).orderBy(
                        Expressions.numberTemplate(
                                Double.class,
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3}))",
                                longitude, latitude,
                                schoolZone.longitude, schoolZone.latitude
                        ).asc()
                ).limit(30)
                .fetch();
    }
}
