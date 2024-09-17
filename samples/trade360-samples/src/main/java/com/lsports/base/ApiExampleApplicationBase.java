package com.lsports.base;

import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.function.Supplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import reactor.core.publisher.Mono;

public abstract class ApiExampleApplicationBase {
    private final Semaphore asyncBarrierSemaphore = new Semaphore(0);
    private int asyncOperationsCount = 0;
    private JsonApiSerializer jsonApiSerializer;

    protected void setJsonApiSerializerForExampleOutputs(JsonApiSerializer jsonApiSerializer) {
        this.jsonApiSerializer = jsonApiSerializer;
    }

    protected <R> void executeSynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeSynchronous(exampleName, null, request -> executeFunction.get());
    }

    protected <T, R> void executeSynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        var newExampleName = "SYNC - " + exampleName;
        System.out.println("--------------------------------");
        try {
            if (request == null) {
                System.out.println("[" + newExampleName + "] - Executing request");
            } else {
                System.out.println("[" + newExampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serializeToString(request));
            }
            var responseMono = executeFunction.apply(request);
            var response = responseMono.block();
            System.out.println("[" + newExampleName + "] - Response received: " + this.jsonApiSerializer.serializeToString(response));
        } catch (Trade360Exception ex) {
            System.out.println("[" + newExampleName + "] - Failed: " + ex.getMessage());
            System.out.println("[" + newExampleName + "] - Errors:");
            ex.getErrors().forEach(error -> System.out.println("[" + newExampleName + "]\t- " + error));
        } catch (Exception ex) {
            System.err.println("[" + newExampleName + "] - Unhandled exception: " + ex.getMessage());
        }

        System.out.flush();
    }

    protected <R> void executeAsynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeAsynchronous(exampleName, null, request -> executeFunction.get());
    }

    protected <T, R> void executeAsynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        var newExampleName = "ASYNC - " + exampleName;
        System.out.println("--------------------------------");
        if (request == null) {
            System.out.println("[" + newExampleName + "] - Executing request");
        } else {
            try {
                System.out.println("[" + newExampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serializeToString(request));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        var responseMono = executeFunction
            .apply(request)
            .doOnNext(response -> {
                System.out.println("--------------------------------");
                try {
                    System.out.println("[" + newExampleName + "] - Got response: " + this.jsonApiSerializer.serializeToString(response));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                System.out.flush();
            });
        this.asyncOperationsCount++;
        responseMono
            .subscribe(
                x -> this.asyncBarrierSemaphore.release(),
                exception -> {
                    System.err.println("[" + newExampleName + "] - Failed: " + exception.getMessage());
                    if (exception instanceof Trade360Exception) {
                        var trade360Exception = (Trade360Exception) exception;
                        System.out.println("[" + newExampleName + "] - Errors:");
                        trade360Exception.getErrors().forEach(error -> System.out.println("[" + newExampleName + "]\t- " + error));
                        System.out.flush();
                    }
                    this.asyncBarrierSemaphore.release();
            });
    }

    protected void waitForAllAsyncFinish() {
        try {
            this.asyncBarrierSemaphore.acquire(this.asyncOperationsCount);
        } catch (InterruptedException e) {
            System.err.println("Failed to wait for all async operations to finish: " + e.getMessage());
        }

        this.asyncOperationsCount = 0;
        this.asyncBarrierSemaphore.drainPermits();
    }
}
