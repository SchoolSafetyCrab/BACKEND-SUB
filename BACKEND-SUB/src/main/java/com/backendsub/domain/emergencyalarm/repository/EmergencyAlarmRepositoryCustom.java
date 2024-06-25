package com.backendsub.domain.emergencyalarm.repository;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;

import java.util.List;

public interface EmergencyAlarmRepositoryCustom {

    List<EmergencyAlarm> findNearByLocation(double latitude, double longitude);
}
