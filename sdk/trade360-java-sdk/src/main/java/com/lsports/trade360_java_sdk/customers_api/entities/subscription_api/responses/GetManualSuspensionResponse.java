package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;

public class GetManualSuspensionResponse {

    public Boolean succeeded;
    public Iterable<Suspension> suspensions;
}
