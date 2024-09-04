package com.lsports.trade360_java_sdk.common.configuration;

import jakarta.annotation.Nullable;

public class PackageCredentials {
    public int packageId;

    @Nullable public String username;

    @Nullable public String password;

    @Nullable public String messageFormat = "json";
}
