package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import reactor.core.publisher.Mono;

/**
 * The {@code ApiRestClient} interface defines methods for making REST API requests.
 */
public interface ApiRestClient {

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
    <Req, Res> Mono<BaseResponse<Res>> postRequest(Req requestBody, TypeReference<BaseResponse<Res>> responseTypeReference, String url);

    /**
     * Sends a POST request without a request body and returns a response of the specified type.
     *
     * @param <Res> the type of the response
     * @param responseTypeReference the type reference of the response
     * @param url the URL to send the request to
     * @return a {@code Mono} emitting the response
     */
    <Res> Mono<BaseResponse<Res>> postRequest(TypeReference<BaseResponse<Res>> responseTypeReference, String url);

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
    <Req, Res> Mono<BaseResponse<Res>> getRequest(Req requestQueryStringObject, TypeReference<BaseResponse<Res>> responseTypeReference, String url);
}