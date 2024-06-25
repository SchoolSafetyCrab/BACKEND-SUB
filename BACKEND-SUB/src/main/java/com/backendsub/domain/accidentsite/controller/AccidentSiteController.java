package com.backendsub.domain.accidentsite.controller;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.service.AccidentSiteService;
import com.backendsub.global.util.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccidentSiteController {

    private final AccidentSiteService accidentSiteService;
    private final HttpResponseUtil responseUtil;

    @GetMapping("/accidentsite")
    public ResponseEntity<?> findAccidentSite(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {

        List<AccidentSite> responses = accidentSiteService.findAccidentSiteNearByLocation(latitude, longitude);
        ResponseEntity<Map<String, Object>> response = responseUtil.createResponse(responses);
        return response;

    }
}
