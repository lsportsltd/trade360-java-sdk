package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.lsports.trade360_java_sdk.common.serialization.JacksonApiSerializer;

import java.net.URI;

import org.springframework.web.reactive.function.client.WebClient;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClientImplementation;
import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiClientFactory;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.springframework.SpringBootApiRestClient;

public class SpringBootSnapshotApiClientFactory implements SnapshotApiClientFactory {
    private final WebClient.Builder builder;

    public SpringBootSnapshotApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public InPlaySnapshotApiClient createInPlayApiClient(URI baseUrl, PackageCredentials credentials) {
        var serializer = new JacksonApiSerializer(credentials);
        var client = new SpringBootApiRestClient(builder, serializer, baseUrl);
        
        return new InPlaySnapshotApiClientImplementation(client);
    }

    @Override
    public PreMatchSnapshotApiClient createPreMatchApiClient(URI baseUrl, PackageCredentials credentials) {
        var serializer = new JacksonApiSerializer(credentials);
        var client = new SpringBootApiRestClient(builder, serializer, baseUrl);
        
        return new PreMatchSnapshotApiClientImplementation(client);
    }
}