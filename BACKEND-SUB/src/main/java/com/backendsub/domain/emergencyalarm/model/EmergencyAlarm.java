package com.backendsub.domain.emergencyalarm.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "emergency_alarm")
public class EmergencyAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emergency_alarm_id")
    private long emergencyAlarmId;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "connection")
    @Enumerated(EnumType.STRING)
    private Connection connection;

    @Column(name = "add_function")
    private String addFunction;

    @Builder
    private EmergencyAlarm(String address, double latitude, double longitude, Connection connection, String addFunction) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connection = connection;
        this.addFunction = addFunction;
    }

    public static EmergencyAlarm createEmergencyAlarm(String address, double latitude, double longitude, Connection connection, String addFunction) {
        return EmergencyAlarm.builder()
                .address(address)
                .latitude(latitude)
                .longitude(longitude)
                .connection(connection)
                .addFunction(addFunction)
                .build();
    }

}
