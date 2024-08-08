package com.lsports.trade360_java_sdk.snapshot_api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class SnapshotApiRestClientFactory {
    public SnapshotApiRestClient getService(RestClient.Builder builder) {
        return new SnapshotApiRestClient(builder);
    }
}