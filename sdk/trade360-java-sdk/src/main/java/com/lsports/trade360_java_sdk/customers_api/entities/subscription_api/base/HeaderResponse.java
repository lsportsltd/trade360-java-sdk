package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatusCode;

public class HeaderResponse {
    public HttpStatusCode httpStatusCode;

    @Nullable public Iterable<Error> errors;
}


class Error{
    @Nullable public String message;
}