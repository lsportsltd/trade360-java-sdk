package com.lsports.trade360_java_sdk.common.entities.enums;

public enum PackageType {
    InPlay (1),
    PreMatch (2);

    private int value;

    PackageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
