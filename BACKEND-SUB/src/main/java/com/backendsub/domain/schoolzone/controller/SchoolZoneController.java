package com.backendsub.domain.schoolzone.controller;

import com.backendsub.domain.schoolzone.domain.SchoolZone;
import com.backendsub.domain.schoolzone.service.SchoolZoneService;
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
public class SchoolZoneController {

    private final SchoolZoneService schoolZoneService;
    private final HttpResponseUtil responseUtil;

    @GetMapping("/school-zone")
    public ResponseEntity<?> findSchoolZone(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude) {
        List<SchoolZone> responses = schoolZoneService.findSchoolZoneNearByLocation(latitude, longitude);
        ResponseEntity<Map<String, Object>> response  = responseUtil.createResponse(responses);
        return response;
    }
}
