package eu.lsports.base;

import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.function.Supplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import reactor.core.publisher.Mono;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ApiExampleApplicationBase {
    private final Semaphore asyncBarrierSemaphore = new Semaphore(0);
    private int asyncOperationsCount = 0;
    private JsonApiSerializer jsonApiSerializer;

    protected static final Logger logger = LogManager.getLogger();

    protected void setJsonApiSerializerForExampleOutputs(JsonApiSerializer jsonApiSerializer) {
        this.jsonApiSerializer = jsonApiSerializer;
    }

    protected <R> void executeSynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeSynchronous(exampleName, null, request -> executeFunction.get());
    }

    protected <T, R> void executeSynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        var newExampleName = "SYNC - " + exampleName;
        try {
            if (request == null) {
                logger.info("[" + newExampleName + "] - Executing request");
            } else {
                logger.info("[" + newExampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serializeToString(request));
            }
            var responseMono = executeFunction.apply(request);
            var response = responseMono.block();
            logger.info("[" + newExampleName + "] - Response received: " + this.jsonApiSerializer.serializeToString(response));
        } catch (Trade360Exception ex) {
            logger.error("[" + newExampleName + "] - Failed: " + ex.getMessage());
            logger.error("[" + newExampleName + "] - Errors:");
            ex.getErrors().forEach(error ->logger.error("[" + newExampleName + "]\t- " + error));
        } catch (Exception ex) {
            logger.error("[" + newExampleName + "] - Unhandled exception: " + ex.getMessage());
        }

        System.out.flush();
    }

    protected <R> void executeAsynchronous(String exampleName, Supplier<Mono<R>> executeFunction) {
        this.executeAsynchronous(exampleName, null, request -> executeFunction.get());
    }

    protected <T, R> void executeAsynchronous(String exampleName, T request, Function<T, Mono<R>> executeFunction) {
        var newExampleName = "ASYNC - " + exampleName;
        if (request == null) {
            logger.info("[" + newExampleName + "] - Executing request");
        } else {
            try {
                logger.info("[" + newExampleName + "] - Executing request - Parameters: " + this.jsonApiSerializer.serializeToString(request));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        var responseMono = executeFunction
            .apply(request);
        this.asyncOperationsCount++;
        responseMono
            .subscribe(
                response -> {
                    try {
                        logger.info("[" + newExampleName + "] - Got response: " + this.jsonApiSerializer.serializeToString(response));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    System.out.flush();
                    this.asyncBarrierSemaphore.release();
                },
                exception -> {
                    logger.error("[" + newExampleName + "] - Failed: " + exception.getMessage());
                    if (exception instanceof Trade360Exception) {
                        var trade360Exception = (Trade360Exception) exception;
                        logger.error("[" + newExampleName + "] - Errors:");
                        trade360Exception.getErrors().forEach(error -> logger.error("[" + newExampleName + "]\t- " + error));
                        System.out.flush();
                    }
                    this.asyncBarrierSemaphore.release();
            });
    }

    protected void waitForAllAsyncFinish() {
        try {
            this.asyncBarrierSemaphore.acquire(this.asyncOperationsCount);
        } catch (InterruptedException e) {
            logger.error("Failed to wait for all async operations to finish: " + e.getMessage());
        }

        this.asyncOperationsCount = 0;
        this.asyncBarrierSemaphore.drainPermits();
    }
}
