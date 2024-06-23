package com.backendsub.domain.accidentsite.service;

import com.backendsub.domain.accidentsite.model.AccidentSite;
import com.backendsub.domain.accidentsite.repository.AccidentSiteRepository;
import com.backendsub.domain.accidentsite.requestDto.AccidentSiteRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccidentSiteServiceTest {

    @InjectMocks
    private AccidentSiteService accidentSiteService;

    @Mock
    private AccidentSiteRepository accidentSiteRepository;

    private AccidentSiteRequestDto requestDto;

    @Mock
    private List<AccidentSite> accidentSites;

    @BeforeEach
    public void init(){
        requestDto = new AccidentSiteRequestDto(36.445326,127.425863);
    }

    @Test
    @DisplayName("사고 우발지 조회 성공 테스트")
    public void 사고_우발지_조회_성공_테스트(){
        //given
        BDDMockito.given(accidentSiteRepository.findNearByLocation(requestDto)).willReturn(accidentSites);

        //when
        List<AccidentSite> responses = accidentSiteService.findNearByLocation(requestDto);
    }
}
