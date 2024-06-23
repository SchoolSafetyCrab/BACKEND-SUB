package com.backendsub.domain.accidentsite.controller;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.requestDto.AccidentSiteRequestDto;
import com.backendsub.domain.accidentsite.service.AccidentSiteService;
import com.backendsub.global.util.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccidentSiteController {

    private final AccidentSiteService accidentSiteService;
    private final HttpResponseUtil responseUtil;
    @GetMapping("/accidentsite")
    public ResponseEntity<?> findAccidentSite(@ModelAttribute AccidentSiteRequestDto requestDto) {

        List<AccidentSite> responses = accidentSiteService.findNearByLocation(requestDto);
        ResponseEntity<Map<String, Object>> response = responseUtil.createResponse(responses);
        return response;

    }
}
