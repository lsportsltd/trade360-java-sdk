package com.lsports.trade360_java_sdk.feed.rabbitmq.configurations;

import lombok.Data;

@Data
public class RabbitConnectionConfiguration {

    public String name;
    public int package_id;
    public String host = "localhost";
    public int port = 5672;
    public String virtual_host = "/";
    public String user_name = "guest";
    public String password = "guest";
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
    public String rabbit_listener_container_factory_name;
}
