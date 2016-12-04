package com.sunzequn.geonames.plus.dao.mysql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * Created by sloriac on 16-12-4.
 */
public class ProxyFactory {

    private static final ProxyFactory instance = new ProxyFactory();

    public static ProxyFactory instance() {
        return instance;
    }

    private ProxyFactory() {
        super();
    }

    public <T> T newProxyInstance(Class<T> type, InvocationHandler handler) {
        return type.cast(Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class<?>[]{type}, handler));
    }

    public Connection createConnection(InvocationHandler handler) {
        return newProxyInstance(Connection.class, handler);
    }
}
