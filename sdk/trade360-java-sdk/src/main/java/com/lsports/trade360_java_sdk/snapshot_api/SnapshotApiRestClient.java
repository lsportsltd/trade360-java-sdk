package com.lsports.trade360_java_sdk.snapshot_api;

public interface SnapshotApiRestClient {

    <Req, Res> Res postRequest(Req requestBody, String url) throws Trade360Exception;

}