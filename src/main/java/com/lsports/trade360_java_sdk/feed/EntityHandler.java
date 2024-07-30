package com.lsports.trade360_java_sdk.feed;

public interface EntityHandler<T>
{
    public void ProcessAsync(T entity);
}
