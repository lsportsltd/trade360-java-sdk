package eu.lsports.trade360_java_sdk.common.http;

import java.util.stream.StreamSupport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import eu.lsports.trade360_java_sdk.common.entities.base.Error;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

/**
 * The {@code LSportsHeaderErrorsExtractor} class implements the {@code ErrorsExtractor} interface to extract errors from the "Header" section of a JSON response.
 */
public class LSportsHeaderErrorsExtractor implements ErrorsExtractor {

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
        try {
            if (bodyJsonNode.has("Header") && bodyJsonNode.get("Header").has("Errors")) {
                var errors = bodyJsonNode.get("Header").get("Errors");
                var parsedErrors = serializer.deserializeToValue(errors.traverse(), new TypeReference<Iterable<Error>>() {});
                return StreamSupport.stream(parsedErrors.spliterator(), false)
                    .map(e -> e.message)
                    .toList();
            } else {
                return null;
            }
        } catch (Throwable e) {
            return null;
        }
    }
}