package com.backendsub.domain.accidentsite.controller;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.service.AccidentSiteService;
import com.backendsub.global.util.HttpResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
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
        controllers = AccidentSiteController.class
)
@MockBean(JpaMetamodelMappingContext.class)
public class AccidentSiteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AccidentSiteService accidentSiteService;

    @MockBean
    private HttpResponseUtil responseUtil;

    private List<AccidentSite> accidentSites;
    private double latitude;
    private double longitude;

    @BeforeEach
    public void init(){
        latitude = 36.445326;
        longitude = 127.425863;
        accidentSites = new ArrayList<>();
    }

    @Test
    @DisplayName("사고 우발지 조회 성공 테스트")
    public void 사고_우발지_조회_성공_테스트() throws Exception {
        // given
        Map<String, Object> mockResponseData = new HashMap<>();
        mockResponseData.put("data", accidentSites);

        BDDMockito.given(accidentSiteService.findAccidentSiteNearByLocation(latitude, longitude)).willReturn(accidentSites);
        BDDMockito.given(responseUtil.createResponse(accidentSites))
                .willReturn(ResponseEntity.ok().body(mockResponseData));

        // when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/accidentsite")
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .contentType(MediaType.APPLICATION_JSON));

        // then

        result.andExpect(MockMvcResultMatchers.status().isOk());

    }
}
