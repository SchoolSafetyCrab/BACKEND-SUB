package com.backendsub.domain.schoolzone.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "school_zone")
public class SchoolZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_zone_id")
    private long schoolZoneId;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "cctv_num")
    private int cctvNum;

    @Column(name = "width")
    private int width;

    @Builder
    private SchoolZone(String type, String name, String address, double latitude, double longitude, int cctvNum, int width) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cctvNum = cctvNum;
        this.width = width;
    }

    public static SchoolZone createSchoolZone(String type, String name, String address, double latitude, double longitude, int cctvNum, int width) {
        return SchoolZone.builder()
                .type(type)
                .name(name)
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .cctvNum(cctvNum)
                .width(width).build();
    }
}
