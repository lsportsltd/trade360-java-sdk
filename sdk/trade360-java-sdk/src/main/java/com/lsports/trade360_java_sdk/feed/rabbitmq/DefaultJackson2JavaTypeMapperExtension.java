package com.lsports.trade360_java_sdk.feed.rabbitmq;

import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;


public class DefaultJackson2JavaTypeMapperExtension extends DefaultJackson2JavaTypeMapper {

    public String getClassIdFieldName() {
        return "type";
    }
}
