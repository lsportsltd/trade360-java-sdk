package eu.lsports.trade360_java_sdk.customers_api.entities.base;
import jakarta.annotation.Nullable;
/**
 * Represents a base response for the subscription API.
 *
 * @param <T> the type of the response body
 */
public class BaseResponse<T> {
    /**
     * /**
     * The header of the response.
     *
     */
    @Nullable
    public HeaderResponse header;

    /**
     * The body of the response.
     */
    @Nullable
    public T body;
}
