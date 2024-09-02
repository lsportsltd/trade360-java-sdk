package com.lsports.trade360_java_sdk.snapshot_api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GenericClassFactoryUtil {
    @SuppressWarnings("unchecked")
    public static <Generic> Class<Iterable<Generic>> makeIterable(Class<Generic> itemClazz) {
        return (Class<Iterable<Generic>>)make(ArrayList.class, itemClazz);
    }

    public static <Raw, Generic> Class<?> make(Class<Raw> rawClazz, Class<Generic> genericTypeClazz) {
        var parameterizedType = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { genericTypeClazz };
            }

            @Override
            public Type getRawType() {
                return rawClazz;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };

        var genericClazz = (Class<?>) parameterizedType.getRawType();

        return genericClazz;
    }
}
