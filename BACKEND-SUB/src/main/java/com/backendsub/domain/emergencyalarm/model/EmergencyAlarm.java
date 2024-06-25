package com.backendsub.domain.emergencyalarm.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private String connection;

    @Column(name = "add_function")
    private String addFunction;


}
