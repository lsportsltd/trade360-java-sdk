package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.JacksonSnapshotApiSerializer;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;

@Service
public class SpringBootSnapshotApiClientFactory implements SnapshotApiClientFactory {
    private final WebClient.Builder builder;

    public SpringBootSnapshotApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public InPlaySnapshotApiClient createInPlayApiClient(SnapshotApiSettings settings) {
        var serializer = new JacksonSnapshotApiSerializer(settings);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, settings);
        
        return new InPlaySnapshotApiClientImplementation(client);
    }

    @Override
    public PreMatchSnapshotApiClient createPreMatchApiClient(SnapshotApiSettings settings) {
        var serializer = new JacksonSnapshotApiSerializer(settings);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, settings);
        
        return new PreMatchSnapshotApiClientImplementation(client);
    }
}