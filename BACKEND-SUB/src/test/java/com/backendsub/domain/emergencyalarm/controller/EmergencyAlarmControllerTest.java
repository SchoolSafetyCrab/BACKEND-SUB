package com.backendsub.domain.emergencyalarm.controller;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.service.EmergencyAlarmService;
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
        controllers = EmergencyAlarmController.class
)
@MockBean(JpaMetamodelMappingContext.class)
public class EmergencyAlarmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmergencyAlarmService emergencyAlarmService;

    @MockBean
    private HttpResponseUtil responseUtil;

    private List<EmergencyAlarm> emergencyAlarms;
    private double latitude;
    private double longitude;

    @BeforeEach
    public void init(){
        emergencyAlarms = new ArrayList<>();
        latitude = 36.445326;
        longitude = 127.425863;
    }

    @Test
    @DisplayName("비상벨_조회_성공_테스트")
    public void 비상벨_조회_성공_테스트() throws Exception {
        //given
        Map<String, Object> mockResponseData = new HashMap<>();
        mockResponseData.put("data", emergencyAlarms);

        BDDMockito.given(emergencyAlarmService.findEmergencyAlarmNearByLocation(latitude, longitude))
                .willReturn(emergencyAlarms);
        BDDMockito.given(responseUtil.createResponse(emergencyAlarms))
                .willReturn(ResponseEntity.ok().body(mockResponseData));

        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/sub/emergency-alarm")
                .param("latitude", String.valueOf(latitude))
                .param("longitude", String.valueOf(longitude))
                .contentType(MediaType.APPLICATION_JSON));

        //then
        result.andExpect(MockMvcResultMatchers.status().isOk());

    }
}
