package com.backendsub.domain.schoolzone.service;

import com.backendsub.domain.schoolzone.domain.SchoolZone;
import com.backendsub.domain.schoolzone.repository.SchoolZoneRepository;
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
public class SchoolZoneServiceTest {

    @InjectMocks
    private SchoolZoneService schoolZoneService;

    @Mock
    private SchoolZoneRepository schoolZoneRepository;

    @Mock
    private List<SchoolZone> responses;

    private double latitude;
    private double longitude;

    @BeforeEach
    public void init(){
        latitude = 36.445326;
        longitude = 127.425863;
    }

    @Test
    @DisplayName("어린이 보호 구역 조회 성공 테스트")
    public void 어린이_보호_구역_조회_성공_테스트(){
        //given
        BDDMockito.given(schoolZoneRepository.findNearByLocation(latitude, longitude))
                .willReturn(responses);

        //when
        List<SchoolZone> response = schoolZoneService.findSchoolZoneNearByLocation(latitude, longitude);
    }
}
