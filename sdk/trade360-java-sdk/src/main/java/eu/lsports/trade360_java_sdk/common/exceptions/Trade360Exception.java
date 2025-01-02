package eu.lsports.trade360_java_sdk.common.exceptions;

import java.util.List;

/**
 * The {@code Trade360Exception} class represents an exception thrown if unexpected situation happens in Trade360 SDK.
 */
public class Trade360Exception extends RuntimeException {

    /**
     * The list of errors associated with the exception.
     */
    private final Iterable<String> errors;

    /**
     * Constructs a new {@code Trade360Exception} with the specified message.
     *
     * @param message the detail message
     */
    public Trade360Exception(String message) {
        this(message, List.of());
    }

    /**
     * Constructs a new {@code Trade360Exception} with the specified message and errors.
     *
     * @param message the detail message
     * @param errors the list of errors associated with the exception
     */
    public Trade360Exception(String message, Iterable<String> errors) {
        super(message);
        this.errors = errors;
    }

    /**
     * Returns the list of errors associated with the exception.
     *
     * @return the list of errors
     */
    public Iterable<String> getErrors() {
        return this.errors;
    }
}