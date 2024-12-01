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

/**
 * Factory for creating Spring Boot-based snapshot API clients.
 */
public class SpringBootSnapshotApiClientFactory implements SnapshotApiClientFactory {
    private final WebClient.Builder builder;

    /**
     * Constructs a new factory with the given WebClient builder.
     * 
     * @param builder the WebClient builder
     */
    public SpringBootSnapshotApiClientFactory(WebClient.Builder builder) {
        this.builder = builder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InPlaySnapshotApiClient createInPlayApiClient(URI baseUrl, PackageCredentials credentials) {
        var serializer = new JacksonApiSerializer(credentials);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, baseUrl);
        
        return new InPlaySnapshotApiClientImplementation(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PreMatchSnapshotApiClient createPreMatchApiClient(URI baseUrl, PackageCredentials credentials) {
        var serializer = new JacksonApiSerializer(credentials);
        var client = new SpringBootSnapshotApiRestClient(builder, serializer, baseUrl);
        
        return new PreMatchSnapshotApiClientImplementation(client);
    }
}