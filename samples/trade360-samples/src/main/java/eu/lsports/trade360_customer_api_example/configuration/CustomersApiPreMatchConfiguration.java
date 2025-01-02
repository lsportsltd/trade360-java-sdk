package eu.lsports.trade360_customer_api_example.configuration;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for CustomersApiPreMatch connection.
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "customersapi.prematch")
public class CustomersApiPreMatchConfiguration {

    /**
     * The ID of the package.
     */
    @NotNull
    public int package_id;

    /**
     * The username for authentication.
     */
    @NotBlank
    public String user_name = "guest";

    /**
     * The password for authentication.
     */
    @NotBlank
    public String password = "guest";

}