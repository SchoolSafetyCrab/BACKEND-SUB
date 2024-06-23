package com.backendsub.domain.accidentsite.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "accident_site")
public class AccidentSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_site_id")
    private long accidentSiteId;

    @Column(name = "year")
    private int year;

    @Column(name = "type")
    private String type;

    @Column(name = "count")
    private int count;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Builder
    public AccidentSite(long accidentSiteId, int year, String type, int count, double latitude, double longitude) {
        this.accidentSiteId = accidentSiteId;
        this.year = year;
        this.type = type;
        this.count = count;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static AccidentSite createAccidentSite (long accidentSiteId, int year, String type, int count, double latitude, double longitude) {
        return AccidentSite.builder()
                .accidentSiteId(accidentSiteId)
                .year(year)
                .type(type)
                .count(count)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
