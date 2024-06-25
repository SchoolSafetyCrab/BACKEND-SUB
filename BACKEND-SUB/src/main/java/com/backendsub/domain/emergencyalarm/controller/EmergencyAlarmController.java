package com.backendsub.domain.emergencyalarm.controller;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.service.EmergencyAlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmergencyAlarmController {

    private final EmergencyAlarmService emergencyAlarmService;

    @GetMapping("/emergency-alarm")
    public List<EmergencyAlarm> getEmergencyAlarm(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude
    ) {

    }
}
