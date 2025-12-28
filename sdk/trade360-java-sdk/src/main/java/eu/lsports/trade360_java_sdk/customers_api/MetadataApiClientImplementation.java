package eu.lsports.trade360_java_sdk.customers_api;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.*;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.MetadataApiClient;
import reactor.core.publisher.Mono;

/**
 * The {@code MetadataApiClientImplementation} class implements the {@link MetadataApiClient} interface to interact with the metadata API.
 */
public class MetadataApiClientImplementation implements MetadataApiClient {
    private final ApiRestClient client;

    /**
     * Constructs a new {@code MetadataApiClientImplementation} with the specified {@link ApiRestClient}.
     *
     * @param client the {@link ApiRestClient}
     */
    public MetadataApiClientImplementation(ApiRestClient client) {
        this.client = client;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSportsResponse>> getSports() {
        return this.getSports(new GetSportsRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSportsResponse>> getSports(GetSportsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetSportsResponse>>() {},
            "Sports/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetLocationsResponse>> getLocations() {
        return this.getLocations(new GetLocationsRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetLocationsResponse>> getLocations(GetLocationsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetLocationsResponse>>() {},
            "Locations/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetLeaguesResponse>> getLeagues(GetLeaguesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetLeaguesResponse>>() {},
            "Leagues/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetMarketsResponse>> getMarkets(GetMarketsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetMarketsResponse>>() {},
            "Markets/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetTranslationsResponse>> getTranslations(GetTranslationsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetTranslationsResponse>>() {},
            "Translation/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetCompetitionsResponse>> getCompetitions(GetCompetitionsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetCompetitionsResponse>>() {},
            "Outright/GetCompetitions"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSubscribedFixturesResponse>> getSubscribedFixtures(GetSubscribedFixturesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetSubscribedFixturesResponse>>() {},
            "Fixtures/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSubscribedFixturesMetadataResponse>> getSubscribedFixturesMetadata(GetSubscribedFixturesMetadataRequest request) {
        return this.client.getRequest(
            request,
            new TypeReference<BaseResponse<GetSubscribedFixturesMetadataResponse>>() {},
            "Fixtures/GetSubscribedMetaData"
        );
    }

    @Override
    public Mono<BaseResponse<GetIncidentsResponse>> getIncidents(GetIncidentsRequest request) {
        return this.client.postRequest(
                request,
                new TypeReference<BaseResponse<GetIncidentsResponse>>() {},
                "Incidents/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetVenuesResponse>> getVenues(GetVenuesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetVenuesResponse>>() {},
            "Venues/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetCitiesResponse>> getCities(GetCitiesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetCitiesResponse>>() {},
            "Cities/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetStatesResponse>> getStates(GetStatesRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetStatesResponse>>() {},
            "States/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetParticipantsResponse>> getParticipants(GetParticipantsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetParticipantsResponse>>() {},
            "Participants/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSeasonsResponse>> getSeasons() {
        return this.getSeasons(new GetSeasonsRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetSeasonsResponse>> getSeasons(GetSeasonsRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetSeasonsResponse>>() {},
            "Seasons/Get"
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetToursResponse>> getTours() {
        return this.getTours(new GetToursRequest());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<BaseResponse<GetToursResponse>> getTours(GetToursRequest request) {
        return this.client.postRequest(
            request,
            new TypeReference<BaseResponse<GetToursResponse>>() {},
            "Tours/Get"
        );
    }
}