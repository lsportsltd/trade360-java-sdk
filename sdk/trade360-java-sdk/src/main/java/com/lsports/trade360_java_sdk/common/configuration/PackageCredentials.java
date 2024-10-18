package com.lsports.trade360_java_sdk.common.configuration;

import java.util.Objects;

/**
 * The {@code PackageCredentials} record represents the credentials required for a package.
 * It includes the package ID, username, password, and message format.
 */
public record PackageCredentials(int packageId, String userName, String password, String messageFormat) {

    /**
     * Constructs a new {@code PackageCredentials} instance with the specified package ID, username, password, and message format.
     * 
     * @param packageId the ID of the package
     * @param userName the username for the package
     * @param password the password for the package
     * @param messageFormat the format of the message according to documentation (e.g., "json")
     * @throws NullPointerException if {@code userName}, {@code password}, or {@code messageFormat} is {@code null}
     */
    public PackageCredentials {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
        Objects.requireNonNull(messageFormat);
    }

    /**
     * Constructs a new {@code PackageCredentials} instance with the specified package ID, username, and password.
     * The message format is set to "json" by default.
     * 
     * @param packageId the ID of the package
     * @param userName the username for the package
     * @param password the password for the package
     * @throws NullPointerException if {@code userName} or {@code password} is {@code null}
     */
    public PackageCredentials(int packageId, String userName, String password) {
        this(packageId, userName, password, "json");
    }
}