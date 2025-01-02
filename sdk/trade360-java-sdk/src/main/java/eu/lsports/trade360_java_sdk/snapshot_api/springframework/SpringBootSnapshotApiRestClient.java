package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.common.http.LSportsHeaderErrorsExtractor;
import eu.lsports.trade360_java_sdk.common.http.ProblemJsonErrorsExtractor;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

/**
 * The {@code SpringBootApiRestClient} class implements the {@link ApiRestClient} interface using Spring WebClient.
 */
public class SpringBootSnapshotApiRestClient implements SnapshotApiRestClient {
    private final WebClient client;
    private final JsonApiSerializer serializer;

    /**
     * Constructs a new {@code SpringBootApiRestClient} with the specified WebClient builder, serializer, and base URL.
     *
     * @param builder the WebClient builder
     * @param serializer the JSON serializer
     * @param baseUrl the base URL for the API
     */
    public SpringBootSnapshotApiRestClient(WebClient.Builder builder, JsonApiSerializer serializer, URI baseUrl) {
        this.serializer = serializer;
        this.client = builder
            .baseUrl(baseUrl.toString())
            .codecs(config -> {
                config.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(serializer.getObjectMapper()));
                config.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(serializer.getObjectMapper(), new MediaType[] {MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM, MediaType.APPLICATION_PROBLEM_JSON}));
            })
            .defaultHeaders(t -> {
                t.setContentType(MediaType.APPLICATION_JSON);
                t.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url){
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serializeRequest(requestBody)))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url) {
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serializeRequest(new Object())))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <Req, Res> Mono<Res> getRequest(Req requestQueryStringObject, TypeReference<Res> responseTypeReference, String url) {
        MultiValueMap<String, String> queryParams;
        try {
            queryParams = this.convertToQueryParams(requestQueryStringObject);
        } catch (IOException e) {
            return Mono.error(e);
        }

        return this.client
            .get()
            .uri(urlBuilder -> urlBuilder
                .path(url)
                .queryParams(queryParams)
                .build())
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    private <Req> MultiValueMap<String, String> convertToQueryParams(Req requestParams) throws IOException {
        var serialized = this.serializer.serializeRequest(requestParams);
        Map<String, String> map = this.serializer.deserializeToValue(serialized.traverse(), new TypeReference<Map<String, String>>() {});
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        map.forEach(params::add);
        return params;
    }

    private <Res> void handleResponse(TypeReference<Res> responseTypeReference, JsonNode parsedResponse, SynchronousSink<Res> sink) {
        try {
            if (parsedResponse == null) {
                throw new Trade360Exception("No correct response received. Ensure that correct Trade360 URL is configured.");
            }

            if (!parsedResponse.has("Header")) {
                throw new Trade360Exception("'Header' property is missing. Please, ensure that you use the correct URL.");
            }

            var body = parsedResponse.get("Body");
            if (body == null) {
                throw new Trade360Exception("'Body' property is missing. Please, ensure that you use the correct URL.");
            }

            var parsedBody = this.serializer.deserializeToValue(body.traverse(), responseTypeReference);

            sink.next(parsedBody);
        }
        catch(IOException ex) {
            sink.error(ex);
        }
    }

    private Mono<Throwable> createErrorMono(ClientResponse response) {
        return extractErrorMessage(response).flatMap(errorMessages ->
            Mono.error(new Trade360Exception("Request failed because of " + response.statusCode() + ".", errorMessages))
        );
    }

    private Mono<Iterable<String>> extractErrorMessage(ClientResponse response) {
        if(response.headers().contentLength().orElse(0L) == 0) {
            return Mono.just(List.of("Unknown error occurred."));
        }

        var errorExtractors = List.of(
            new LSportsHeaderErrorsExtractor(),
            new ProblemJsonErrorsExtractor()
        );
        
        return response.bodyToMono(JsonNode.class).map(body -> {
            var extractedErrors = StreamSupport.stream(errorExtractors.spliterator(), false)
                .map(e -> e.extractErrors(body, this.serializer))
                .filter(e -> e != null)
                .findFirst();

            if (extractedErrors.isPresent()) {
                return extractedErrors.get();
            } else {
                return List.of("Unknown error occurred.");
            }
        });
    }
}