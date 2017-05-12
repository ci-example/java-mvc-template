package com.flow.pooling.domain;

import java.io.Serializable;

/**
 * Created by gyfirim on 25/04/2017.
 *
 * @Copyright fir.im
 */
public enum HostStatus implements Serializable {
    ONLINE("ONLINE"),

    DELETED("DELETED"),

    CREATED("CREATED"),

    OFFLINE("OFFLINE");

    private String name;

    HostStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
