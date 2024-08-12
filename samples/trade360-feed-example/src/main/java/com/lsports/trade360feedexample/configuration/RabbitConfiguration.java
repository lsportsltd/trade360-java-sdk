package com.lsports.trade360feedexample.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "rabbit")
@ConfigurationPropertiesScan
public class RabbitConfiguration {
    int package_id;
    String host;
    int port;
    String virtual_host;
    int packageId;
    String user_name;
    String password;
    int prefetch_count;
    boolean auto_ack;
    int requested_heartbeat_seconds;
    int network_recovery_interval;
    boolean dispatch_consumers_async;
    boolean automatic_recovery_enabled;
    String base_customers_api;

}
