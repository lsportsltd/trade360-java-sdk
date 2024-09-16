package com.lsports.trade360_java_sdk.common.exceptions;

import java.util.List;

public class Trade360Exception extends RuntimeException {
    private final Iterable<String> errors;

    public Trade360Exception(String message) {
        this(message, List.of());
    }

    public Trade360Exception(String message, Iterable<String> errors) {
        super(message);
        this.errors = errors;
    }

    public Iterable<String> getErrors() {
        return this.errors;
    }
}
