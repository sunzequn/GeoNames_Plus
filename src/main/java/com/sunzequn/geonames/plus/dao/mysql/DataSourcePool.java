package com.sunzequn.geonames.plus.dao.mysql;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;


/**
 * Created by sloriac on 16-12-4.
 */
public class DataSourcePool {

    private Logger logger = Logger.getLogger(DataSourcePool.class);
    private String user;
    private String password;
    private String driverClass;
    private String jdbcUrl;
    private int initialPoolSize;

    private LinkedList<Connection> connections = new LinkedList<>();

    public DataSourcePool(String user, String password, String driverClass, String jdbcUrl, int initialPoolSize) {
        this.user = user;
        this.password = password;
        this.driverClass = driverClass;
        this.jdbcUrl = jdbcUrl;
        this.initialPoolSize = initialPoolSize;

        for (int i = 0; i < this.initialPoolSize; i++) {
            Connection connection = generateConnection();
            if (connection != null) {
                connections.add(connection);
            }
        }
        logger.info("连接池链接数量: " + connections.size());
    }

    private Connection generateConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Connection getConnection() throws SQLException {
        if (connections.size() > 0) {
            final Connection connection = connections.pop();
            ConnectionInvocationHandler connHandler = new ConnectionInvocationHandler(connection, connections);
            return ProxyFactory.instance().createConnection(connHandler);
        } else {
            //
            return null;
        }
    }

}
