package com.lsports.trade360_java_sdk.common.configuration;

import java.net.URI;
import java.util.Objects;

public record PackageCredentials(URI baseUrl, int packageId, String userName, String password, String messageFormat) {
    public PackageCredentials {
        Objects.requireNonNull(baseUrl);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
        Objects.requireNonNull(messageFormat);
    }

    public PackageCredentials(URI baseUrl, int packageId, String userName, String password) {
        this(baseUrl,packageId,userName,password,"json");
    }
}