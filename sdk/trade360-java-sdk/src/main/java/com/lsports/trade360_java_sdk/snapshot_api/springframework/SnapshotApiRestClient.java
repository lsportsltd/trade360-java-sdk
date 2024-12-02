package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import reactor.core.publisher.Mono;

/**
 * The {@code ApiRestClient} interface defines methods for making REST API requests.
 */
public interface SnapshotApiRestClient {

    /**
     * Sends a POST request with a request body and returns a response of the specified type.
     *
     * @param <Req> the type of the request body
     * @param <Res> the type of the response
     * @param requestBody the request body
     * @param responseTypeReference the type reference of the response
     * @param url the URL to send the request to
     * @return a {@code Mono} emitting the response
     */
    <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url);

    /**
     * Sends a POST request without a request body and returns a response of the specified type.
     *
     * @param <Res> the type of the response
     * @param responseTypeReference the type reference of the response
     * @param url the URL to send the request to
     * @return a {@code Mono} emitting the response
     */
    <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url);

    /**
     * Sends a GET request with a query string object and returns a response of the specified type.
     *
     * @param <Req> the type of the query string object
     * @param <Res> the type of the response
     * @param requestQueryStringObject the query string object
     * @param responseTypeReference the type reference of the response
     * @param url the URL to send the request to
     * @return a {@code Mono} emitting the response
     */
    <Req, Res> Mono<Res> getRequest(Req requestQueryStringObject, TypeReference<Res> responseTypeReference, String url);
}