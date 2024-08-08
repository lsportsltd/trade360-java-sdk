package com.lsports.trade360_snapshot_api_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;

import jakarta.annotation.PostConstruct;

@Component
public class ExampleRunner {
    @Autowired
    private InPlaySnapshotApiClient inPlayClient;
    
    @Autowired
    private PreMatchSnapshotApiClient preMatchClient;

    @PostConstruct
    public void run() {
        this.preMatchApi();
        this.inPlayApi();
    }

    private void preMatchApi(){
        this.execute(() -> this.preMatchClient.getFixtures(new GetFixturesRequestDto(null, null, null, null, null, null)));
    }

    private void inPlayApi(){
        this.execute(() -> this.inPlayClient.getFixtures(new GetFixturesRequestDto(null, null, null, null, null, null)));
    }

    private <R> void execute(Func<R> c){
        var response = c.accept();
        System.out.println("Response received: " + response);
    }

    @FunctionalInterface
    private interface Func<R> {
        R accept();
    }
}