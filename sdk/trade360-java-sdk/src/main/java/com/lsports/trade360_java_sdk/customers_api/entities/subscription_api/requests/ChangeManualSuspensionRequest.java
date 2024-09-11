package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import jakarta.annotation.Nullable;

public class ChangeManualSuspensionRequest {
    @Nullable public Iterable<Suspension> suspensions;
}
