package eu.lsports.trade360_java_sdk.snapshot_api;

import java.net.URI;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;

/**
 * Factory for creating Snapshot API clients.
 */
public interface SnapshotApiClientFactory {

    /**
     * Creates a client for the In-Play Snapshot API.
     *
     * @param baseUrl The base URL of the API
     * @param credentials The credentials for the package
     * @return A new instance of {@link InPlaySnapshotApiClient}
     */
    InPlaySnapshotApiClient createInPlayApiClient(URI baseUrl, PackageCredentials credentials);

    /**
     * Creates a client for the Pre-Match Snapshot API.
     *
     * @param baseUrl The base URL of the API
     * @param credentials The credentials for the package
     * @return A new instance of {@link PreMatchSnapshotApiClient}
     */
    PreMatchSnapshotApiClient createPreMatchApiClient(URI baseUrl, PackageCredentials credentials);
}