package com.lsports.trade360_snapshot_api_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;

import jakarta.annotation.PostConstruct;

@Component
public class ExampleRunner {
    @Autowired
    private InPlaySnapshotApiClient client;

    @PostConstruct
    public void run() {
        var response = this.client.getFixtures(new GetFixturesRequestDto(null, null, null, null, null, null));
        System.out.println("Response received: " + response);
    }
}