package com.lsports.trade360_snapshot_api_example.configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for CustomersApiPreMatch connection.
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "snapshotspi.prematch")
public class SnapshotApiPreMatchConfiguration {

    /**
     * The ID of the package.
     */
    @NotNull
    public int package_id;

    /**
     * The username for authentication.
     */
    @NotBlank
    public String user_name = "guest";

    /**
     * The password for authentication.
     */
    @NotBlank
    public String password = "guest";

}