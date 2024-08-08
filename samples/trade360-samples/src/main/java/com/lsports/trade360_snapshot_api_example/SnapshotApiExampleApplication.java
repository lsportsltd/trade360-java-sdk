package com.lsports.trade360_snapshot_api_example;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.lsports.trade360_java_sdk.snapshot_api.SnapshotApiBeanNames;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages = "com.lsports.trade360_java_sdk")
public class SnapshotApiExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnapshotApiExampleApplication.class, args);
    }

    @Bean(SnapshotApiBeanNames.INPLAY_API_SETTINGS)
    public SnapshotApiSettings configureInPlayApiSettings() {
        return new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 2, "1", "Tests1234");
    }

    @Bean(SnapshotApiBeanNames.PREMATCH_API_SETTINGS)
    public SnapshotApiSettings configurePreMatchApiSettings() {
        return new SnapshotApiSettings(URI.create("https://stm-snapshot.lsports.eu"), 4, "1", "Tests1234");
    }
}
