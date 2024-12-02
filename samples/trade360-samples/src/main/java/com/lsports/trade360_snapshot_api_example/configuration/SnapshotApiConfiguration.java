package com.lsports.trade360_snapshot_api_example.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "snapshotapi")
@EnableConfigurationProperties({SnapshotApiInPlayConfiguration.class, SnapshotApiPreMatchConfiguration.class})
public class SnapshotApiConfiguration {
    public String base_snapshot_api;

    public SnapshotApiInPlayConfiguration inplay;

    public SnapshotApiPreMatchConfiguration prematch;
}
