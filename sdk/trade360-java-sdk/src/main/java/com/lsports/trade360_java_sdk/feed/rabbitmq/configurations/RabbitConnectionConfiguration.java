package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class RabbitConnectionConfiguration {


    public String name;
    @NotNull
    public int package_id;
    @NotBlank
    public String host = "localhost";
    @NotNull
    public int port = 5672;
    @NotBlank
    public String virtual_host = "/";
    @NotBlank
    public String user_name = "guest";
    @NotBlank
    public String password = "guest";
    @NotNull
    public int prefetch_count;
    @NotNull
    public boolean auto_ack = true;
    @NotNull
    public int requested_heartbeat_seconds = 30;
    @NotNull
    public int network_recovery_interval = 30;
    @NotBlank
    public String base_customers_api;
    @NotNull
    public int retry_attempts = 3;
    @NotNull
    public int retry_initial_interval = 1000;
    @NotNull
    public double retry_multiple = 2;
    @NotNull
    public int retry_max_interval = 5000;
    @NotNull
    public int concurrent_consumers = 1;
    @NotNull
    public int max_concurrent_consumers = 20;
    @NotBlank
    public String rabbit_listener_container_factory_name;
}
