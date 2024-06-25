package com.backendsub.domain.schoolzone.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSchoolZone is a Querydsl query type for SchoolZone
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSchoolZone extends EntityPathBase<SchoolZone> {

    private static final long serialVersionUID = -2143500623L;

    public static final QSchoolZone schoolZone = new QSchoolZone("schoolZone");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> cctvNum = createNumber("cctvNum", Integer.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> schoolZoneId = createNumber("schoolZoneId", Long.class);

    public final StringPath type = createString("type");

    public final NumberPath<Integer> width = createNumber("width", Integer.class);

    public QSchoolZone(String variable) {
        super(SchoolZone.class, forVariable(variable));
    }

    public QSchoolZone(Path<? extends SchoolZone> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSchoolZone(PathMetadata metadata) {
        super(SchoolZone.class, metadata);
    }

}

