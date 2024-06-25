package com.backendsub.domain.schoolzone.controller;

import com.backendsub.domain.schoolzone.domain.SchoolZone;
import com.backendsub.domain.schoolzone.service.SchoolZoneService;
import com.backendsub.global.util.HttpResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebMvcTest(
        controllers = SchoolZoneController.class
)
@MockBean(JpaMetamodelMappingContext.class)
public class SchoolZoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SchoolZoneService schoolZoneService;

    @MockBean
    private HttpResponseUtil responseUtil;

    private List<SchoolZone>schoolZones;
    private double latitude;
    private double longitude;

    @BeforeEach
    public void init(){
        schoolZones = new ArrayList<>();
        latitude = 36.445326;
        longitude = 127.425863;
    }

    @Test
    @DisplayName("어린이 보호 구역 조회 성공 테스트")
    public void 어린이_보호_구역_조회_성공_테스트() throws Exception {
        //given
        Map<String, Object> mockResponseData = new HashMap<>();
        mockResponseData.put("data", schoolZones);

        BDDMockito.given(schoolZoneService.findSchoolZoneNearByLocation(latitude, longitude)).willReturn(schoolZones);
        BDDMockito.given(responseUtil.createResponse(schoolZones))
                .willReturn(ResponseEntity.ok().body(mockResponseData));

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/school-zone")
            .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}