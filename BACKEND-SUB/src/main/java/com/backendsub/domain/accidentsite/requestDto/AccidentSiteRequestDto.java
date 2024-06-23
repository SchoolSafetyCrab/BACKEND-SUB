package com.backendsub.domain.accidentsite.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccidentSiteRequestDto {

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;
}
