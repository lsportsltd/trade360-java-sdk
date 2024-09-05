package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

public class BaseResponse<T> {
    @Nullable public HeaderResponse header;

    @Nullable public T body;
}
