package eu.lsports.trade360_java_sdk.common.entities.livescore;

import jakarta.annotation.Nullable;

/**
 * The {@code Result} class represents a result in a live score event.
 */
public class Result {

    /**
     * The position associated with the result.
     * This can be {@code null} if not set.
     */
    @Nullable public String position;

    /**
     * The value of the result.
     * This can be {@code null} if not set.
     */
    @Nullable public String value;
}