package com.lsports.trade360_java_sdk.common.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonApiSerializer {
    <R> Object serialize(R request);

    ObjectMapper getJsonMapper();
}
