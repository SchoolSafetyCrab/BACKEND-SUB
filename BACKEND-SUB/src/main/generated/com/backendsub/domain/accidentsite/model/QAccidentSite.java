package com.backendsub.domain.accidentsite.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccidentSite is a Querydsl query type for AccidentSite
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccidentSite extends EntityPathBase<AccidentSite> {

    private static final long serialVersionUID = 1463047294L;

    public static final QAccidentSite accidentSite = new QAccidentSite("accidentSite");

    public final NumberPath<Long> accidentSiteId = createNumber("accidentSiteId", Long.class);

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath type = createString("type");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QAccidentSite(String variable) {
        super(AccidentSite.class, forVariable(variable));
    }

    public QAccidentSite(Path<? extends AccidentSite> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccidentSite(PathMetadata metadata) {
        super(AccidentSite.class, metadata);
    }

}

