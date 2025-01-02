package eu.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixtureRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetInPlayEventRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;
import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link InPlaySnapshotApiClient} interface.
 */
public class InPlaySnapshotApiClientImplementation implements InPlaySnapshotApiClient {
    private final SnapshotApiRestClient client;

    /**
     * Constructs a new InPlaySnapshotApiClientImplementation with the given API client.
     *
     * @param client The API client
     */
    public InPlaySnapshotApiClientImplementation(SnapshotApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixturesResultElement>> getFixtures(GetFixtureRequest getFixturesRequest) {
        return this.client.postRequest(
            getFixturesRequest,
            new TypeReference<Iterable<GetFixturesResultElement>>(){},
            "/Inplay/GetFixtures");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetLivescoreResultElement>> getLivescore(GetLivescoreRequest getLivescoreRequest) {
        return this.client.postRequest(
            getLivescoreRequest,
            new TypeReference<Iterable<GetLivescoreResultElement>>(){},
            "/Inplay/GetScores");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetFixtureMarketsResultElement>> getFixtureMarkets(GetMarketRequest getMarketRequest) {
        return this.client.postRequest(
            getMarketRequest,
            new TypeReference<Iterable<GetFixtureMarketsResultElement>>(){},
            "/Inplay/GetFixtureMarkets");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Iterable<GetEventsResultElement>> getEvents(GetInPlayEventRequest getEventsRequest) {
        return this.client.postRequest(
            getEventsRequest,
            new TypeReference<Iterable<GetEventsResultElement>>(){},
            "/Inplay/GetEvents");
    }
}