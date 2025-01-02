package eu.lsports.trade360_java_sdk.common.serialization;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

/**
 * The {@code JacksonApiSerializer} class implements the {@link JsonApiSerializer} interface using the Jackson library.
 */
public class JacksonApiSerializer implements JsonApiSerializer {
    private final ObjectMapper jsonMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule().addSerializer(new LSportsLocalDateTimeSerializer()))
        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(Include.NON_NULL);

    private final PackageCredentials packageCredentials;

    /**
     * Constructs a new {@code JacksonApiSerializer} with the specified package credentials.
     *
     * @param packageCredentials the package credentials to include in serialized requests
     */
    public JacksonApiSerializer(PackageCredentials packageCredentials) {
        this.packageCredentials = packageCredentials;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ObjectNode serializeRequest(R request) {
        ObjectNode jsonObject = this.jsonMapper.createObjectNode();
        if(request != null) {
            jsonObject = this.jsonMapper.valueToTree(request);
            if (this.packageCredentials == null) {
                return jsonObject;
            }
        }

        jsonObject.put("PackageId", this.packageCredentials.packageId());
        jsonObject.put("UserName", this.packageCredentials.userName());
        jsonObject.put("Password", this.packageCredentials.password());
        jsonObject.put("MessageFormat", this.packageCredentials.messageFormat());

        return jsonObject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> String serializeToString(R request) throws JsonProcessingException {
        return this.jsonMapper.writeValueAsString(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonNode deserializeToTree(String json) throws JsonProcessingException {
        return this.jsonMapper.readTree(json);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T deserializeToValue(JsonParser jsonParser, TypeReference<T> valueTypeRef) throws IOException {
        return this.jsonMapper.readValue(jsonParser, valueTypeRef);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> R convertValue(T fromValue, TypeReference<R> valueTypeRef) {
        return this.jsonMapper.convertValue(fromValue, valueTypeRef);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectMapper getObjectMapper() {
        return this.jsonMapper;
    }
}