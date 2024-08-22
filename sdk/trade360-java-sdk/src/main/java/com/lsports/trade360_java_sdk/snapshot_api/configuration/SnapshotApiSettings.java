package com.lsports.trade360_java_sdk.snapshot_api.configuration;

import java.net.URI;
import java.util.Objects;

public record SnapshotApiSettings(URI baseUrl, int packageId, String userName, String password) {
    public SnapshotApiSettings {
        Objects.requireNonNull(baseUrl);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
    }
}
