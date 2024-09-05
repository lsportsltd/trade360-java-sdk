package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotSnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotSnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;

@Service
public class SpringBootSnapshotApiClientFactory implements SnapshotApiClientFactory {
    private final WebClient.Builder builder;

    public SpringBootSnapshotApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public InPlaySnapshotApiClient createInPlayApiClient(PackageCredentials settings) {
        var serializer = new JacksonApiSerializer(settings);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, settings);
        
        return new InPlaySnapshotSnapshotApiClientImplementation(client);
    }

    @Override
    public PreMatchSnapshotApiClient createPreMatchApiClient(PackageCredentials settings) {
        var serializer = new JacksonApiSerializer(settings);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, settings);
        
        return new PreMatchSnapshotSnapshotApiClientImplementation(client);
    }
}