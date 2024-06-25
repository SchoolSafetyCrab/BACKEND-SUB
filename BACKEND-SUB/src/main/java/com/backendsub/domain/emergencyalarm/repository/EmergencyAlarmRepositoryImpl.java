package com.backendsub.domain.emergencyalarm.repository;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.model.QEmergencyAlarm;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmergencyAlarmRepositoryImpl implements EmergencyAlarmRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private QEmergencyAlarm emergencyAlarm = QEmergencyAlarm.emergencyAlarm;

    @Override
    public List<EmergencyAlarm> findNearByLocation(double latitude, double longitude) {
        return queryFactory
                .selectFrom(emergencyAlarm)
                .where(
                        Expressions.booleanTemplate(
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3})) <= {4}",
                                longitude, latitude,
                                emergencyAlarm.longitude, emergencyAlarm.latitude,
                                10000
                        )
                )
                .orderBy(
                        Expressions.numberTemplate(
                                Double.class,
                                "ST_Distance_Sphere(POINT({0}, {1}), POINT({2}, {3}))",
                                longitude, latitude,
                                emergencyAlarm.longitude, emergencyAlarm.latitude
                        ).asc()
                )
                .limit(30)
                .fetch();

    }
}
