package com.lsports.trade360_snapshot_api_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lsports.trade360_java_sdk.snapshot_api.InPlaySnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.PreMatchSnapshotApiClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;

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
        System.out.println("================================");
        System.out.println("==== PREMATCH API EXAMPLES: ====");
        this.execute("Get Fixtures", () -> this.preMatchClient.getFixtures(new GetFixturesRequestDto(null, null, null, null, null, null)));
        this.execute("Get Livescore", () -> this.preMatchClient.getLivescore(new GetLivescoreRequestDto(null, null, null, null, null, null)));
    }

    private void inPlayApi(){
        System.out.println("================================");
        System.out.println("==== INPLAY API EXAMPLES: ====");
        this.execute("Get Fixtures", () -> this.inPlayClient.getFixtures(new GetFixturesRequestDto(null, null, null, null, null, null)));
        this.execute("Get Livescore", () -> this.inPlayClient.getLivescore(new GetLivescoreRequestDto(null, null, null, null, null, null)));
    }

    private <R> void execute(String exampleName, Func<R> c){
        var response = c.accept();
        System.out.println("[" + exampleName + "]" + " Response received: " + response);
    }

    @FunctionalInterface
    private interface Func<R> {
        R accept();
    }
}