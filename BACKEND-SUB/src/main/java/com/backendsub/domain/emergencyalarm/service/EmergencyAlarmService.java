package com.backendsub.domain.emergencyalarm.service;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.repository.EmergencyAlarmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class EmergencyAlarmService {

    private final EmergencyAlarmRepository emergencyAlarmRepository;

    @Transactional
    public List<EmergencyAlarm> findEmergencyAlarmNearByLocation(double latitude, double longitude) {
        List<EmergencyAlarm> responses = emergencyAlarmRepository.findNearByLocation(latitude, longitude);
        return responses;
    }
}
