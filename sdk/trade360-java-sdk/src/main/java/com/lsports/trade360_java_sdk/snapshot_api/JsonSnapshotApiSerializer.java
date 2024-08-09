package com.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonSnapshotApiSerializer {
    <R> Object serialize(R request);

    ObjectMapper getJsonMapper();
}
