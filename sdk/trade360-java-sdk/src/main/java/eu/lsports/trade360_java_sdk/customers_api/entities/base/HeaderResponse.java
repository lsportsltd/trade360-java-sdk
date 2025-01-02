package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatusCode;

/**
 * Represents the header of a response.
 */
public class HeaderResponse {
    /**
     * The HTTP status code of the response.
     *
     * @see HttpStatusCode
     */
    public HttpStatusCode httpStatusCode;

    /**
     * The errors associated with the response, if any.
     */
    @Nullable
    public Iterable<Error> errors;
}