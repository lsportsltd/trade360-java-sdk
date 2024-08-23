package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("rabbitmq.inplay")
public class RabbitConnectionConfiguration {

    public String name;
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
    public int retry_attempts = 3;
    public int retry_initial_interval = 1000;
    public double retry_multiple = 2;
    public int retry_max_interval = 5000;
    public int concurrent_consumers = 1;
    public int max_concurrent_consumers = 20;
    public int pre_fetch_count = 250;


}
