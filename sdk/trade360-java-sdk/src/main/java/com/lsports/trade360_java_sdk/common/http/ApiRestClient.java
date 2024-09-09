package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import reactor.core.publisher.Mono;

public interface ApiRestClient {
    <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url) throws Trade360Exception;

    <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url) throws Trade360Exception;

}