package com.backendsub.domain.emergencyalarm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Connection {

    단방향("단방향"),
    양방향("양방향"),
    미연계("미연계");

    private String connection;
}
