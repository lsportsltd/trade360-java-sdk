package com.lsports.trade360_java_sdk.feed.configuration;

public class RmqConnectionSettings
{
        public String host;
        public int port;
        public String VirtualHost;
        public int packageId;
        public String userName;
        public String password;
        public short prefetchCount = 100; // Default 100;
        public Boolean dispatchConsumersAsync = true; // Default true;
        public Boolean automaticRecoveryEnabled = true; // Default true;
        public Boolean autoAck = true; // Default true;
        public int requestedHeartbeatSeconds = 30; // Default 30 seconds
        public int networkRecoveryInterval = 30; // Default 30 seconds
        public String baseCustomersApi = "https://stm-api.lsports.eu";
}
