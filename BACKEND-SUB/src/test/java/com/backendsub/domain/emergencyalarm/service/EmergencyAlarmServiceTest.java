package com.backendsub.domain.emergencyalarm.service;

import com.backendsub.domain.emergencyalarm.model.EmergencyAlarm;
import com.backendsub.domain.emergencyalarm.repository.EmergencyAlarmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmergencyAlarmServiceTest {

    @InjectMocks
    private EmergencyAlarmService emergencyAlarmService;

    @Mock
    private EmergencyAlarmRepository emergencyAlarmRepository;

    @Mock
    private List<EmergencyAlarm> responses;

    private double latitude;
    private double longitude;

    @BeforeEach
    public void init(){
        latitude = 36.445326;
        longitude = 127.425863;
    }

    @Test
    @DisplayName("비상벨 데이터 조회 성공 테스트")
    public void 비상벨_데이터_조회_성공_테스트(){
        //given
        BDDMockito.given(emergencyAlarmRepository.findNearByLocation(latitude, longitude)).willReturn(responses);

        //when
        List<EmergencyAlarm> responses = emergencyAlarmService.findEmergencyAlarmNearByLocation(latitude, longitude);
    }
}
