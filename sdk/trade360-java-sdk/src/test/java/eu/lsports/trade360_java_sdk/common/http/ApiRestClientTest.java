package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.*;

class ApiRestClientTest {
    static class DummyApiRestClient implements ApiRestClient {
        @Override
        public <Req, Res> Mono<BaseResponse<Res>> postRequest(Req requestBody, TypeReference<BaseResponse<Res>> responseTypeReference, String url) {
            return Mono.just(new BaseResponse<>());
        }
        @Override
        public <Res> Mono<BaseResponse<Res>> postRequest(TypeReference<BaseResponse<Res>> responseTypeReference, String url) {
            return Mono.just(new BaseResponse<>());
        }
        @Override
        public <Req, Res> Mono<BaseResponse<Res>> getRequest(Req requestQueryStringObject, TypeReference<BaseResponse<Res>> responseTypeReference, String url) {
            return Mono.just(new BaseResponse<>());
        }
    }
    @Test
    void testPostAndGetRequest() {
        DummyApiRestClient client = new DummyApiRestClient();
        assertNotNull(client.postRequest(new Object(), new TypeReference<BaseResponse<Object>>() {}, "url"));
        assertNotNull(client.getRequest(new Object(), new TypeReference<BaseResponse<Object>>() {}, "url"));
    }
} 