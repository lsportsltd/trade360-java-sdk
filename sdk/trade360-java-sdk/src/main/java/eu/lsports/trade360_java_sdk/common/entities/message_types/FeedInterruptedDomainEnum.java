package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FeedInterruptedDomainEnum {
    Markets(1);

    private final int value;

    FeedInterruptedDomainEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
