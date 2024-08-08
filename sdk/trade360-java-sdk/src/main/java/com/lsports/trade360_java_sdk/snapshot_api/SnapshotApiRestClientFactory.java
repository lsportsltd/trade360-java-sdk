package com.lsports.trade360_java_sdk.snapshot_api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;

@Service
class SnapshotApiRestClientFactory {
    public SnapshotApiRestClient getService(RestClient.Builder builder, SnapshotApiSettings settings) {
        var client = new SnapshotApiRestClient(builder);
        client.configure(settings);
        
        return client;
    }
}