package com.backendsub.domain.emergencyalarm.controller;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.service.EmergencyAlarmService;
import com.backendsub.global.util.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sub")
public class EmergencyAlarmController {

    private final EmergencyAlarmService emergencyAlarmService;
    private final HttpResponseUtil responseUtil;

    @GetMapping("/emergency-alarm")
    public ResponseEntity<?> getEmergencyAlarm(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude
    ) {
        List<EmergencyAlarm> responses = emergencyAlarmService.findEmergencyAlarmNearByLocation(latitude, longitude);
        ResponseEntity<Map<String, Object>> response = responseUtil.createResponse(responses);
        return response;
    }
}
