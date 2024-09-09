package com.lsports.trade360_java_sdk.common.configuration;

import java.util.Objects;

public record PackageCredentials(int packageId, String userName, String password, String messageFormat) {
    public PackageCredentials {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
        Objects.requireNonNull(messageFormat);
    }

    public PackageCredentials(int packageId, String userName, String password) {
        this(packageId, userName, password, "json");
    }
}