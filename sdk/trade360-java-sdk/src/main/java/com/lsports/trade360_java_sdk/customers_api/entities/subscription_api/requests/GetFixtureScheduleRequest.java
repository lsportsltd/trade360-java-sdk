package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

public record GetFixtureScheduleRequest(
    Iterable<Integer> sportIds,
    Iterable<Integer> locationIds,
    Iterable<Integer> leagueIds){
}
