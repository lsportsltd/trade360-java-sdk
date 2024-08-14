package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("rabbitmq.inplay")
public class RabbitConfiguration {

    public int package_id;

    public String host;

    public int port;

    public String virtual_host;

    public String user_name;

    public String password;

    public int prefetch_count;

    public boolean auto_ack = true;

    public int requested_heartbeat_seconds = 30;

    public int network_recovery_interval = 30;

    public boolean dispatch_consumers_async = true;

    public boolean automatic_recovery_enabled = true;

    public String base_customers_api;

}
