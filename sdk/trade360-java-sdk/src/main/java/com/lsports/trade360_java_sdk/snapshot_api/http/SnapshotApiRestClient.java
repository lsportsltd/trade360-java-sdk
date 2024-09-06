package com.lsports.trade360_java_sdk.snapshot_api.http;

import com.fasterxml.jackson.core.type.TypeReference;
import reactor.core.publisher.Mono;

public interface SnapshotApiRestClient {
    <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url);
}