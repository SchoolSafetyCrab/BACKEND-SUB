package com.backendsub.domain.emergencyalarm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Connection {

    CONNECTION_ONEWAY("단방향"),
    CONNECTION_TWO_WAY("양방향"),
    CONNECTION_UN_DIRECTION("미방향");

    private String connection;
}
