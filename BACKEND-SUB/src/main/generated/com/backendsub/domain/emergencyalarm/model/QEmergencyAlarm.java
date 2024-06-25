package com.backendsub.domain.emergencyalarm.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmergencyAlarm is a Querydsl query type for EmergencyAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmergencyAlarm extends EntityPathBase<EmergencyAlarm> {

    private static final long serialVersionUID = -496215618L;

    public static final QEmergencyAlarm emergencyAlarm = new QEmergencyAlarm("emergencyAlarm");

    public final StringPath addFunction = createString("addFunction");

    public final StringPath address = createString("address");

    public final EnumPath<Connection> connection = createEnum("connection", Connection.class);

    public final NumberPath<Long> emergencyAlarmId = createNumber("emergencyAlarmId", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public QEmergencyAlarm(String variable) {
        super(EmergencyAlarm.class, forVariable(variable));
    }

    public QEmergencyAlarm(Path<? extends EmergencyAlarm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmergencyAlarm(PathMetadata metadata) {
        super(EmergencyAlarm.class, metadata);
    }

}

