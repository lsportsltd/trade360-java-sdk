package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code UniformColor} class represents participant shirt color details.
 */
public class UniformColor {
    /**
     * Main shirt color.
     * This can be {@code null} if not set.
     */
    @Nullable public String primary;

    /**
     * Number color.
     * This can be {@code null} if not set.
     */
    @Nullable public String number;

    /**
     * Outline color.
     * This can be {@code null} if not set.
     */
    @Nullable public String outline;
}
