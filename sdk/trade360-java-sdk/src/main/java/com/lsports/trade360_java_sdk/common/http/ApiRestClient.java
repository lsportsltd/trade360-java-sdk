package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import reactor.core.publisher.Mono;

public interface ApiRestClient {
    <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url);

    <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url);

    <Req, Res> Mono<Res> getRequest(Req requestQueryStringObject, TypeReference<Res> responseTypeReference, String url); 
}