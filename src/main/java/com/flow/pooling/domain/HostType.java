package com.flow.pooling.domain;

import java.io.Serializable;

/**
 * Define type of machine resource that supported
 *
 * Created by gy@fir.im on 25/04/2017.
 * @Copyright fir.im
 */
public enum HostType implements Serializable {

    MEITUAN_ECS("MEITUAN_ECS"),

    MEITUAN_MAC("MEITUAN_MAC"),

    ALI_ECS("ALI_ECS"),

    ALI_DOCKER("ALI_DOCKER"),

    FIR_MAC("FIR_MAC");

    private String name;

    HostType(String name) {
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
