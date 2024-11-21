package com.luis.neumann.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class InfrastructureConfig {
    public DataSource createDataSourceMysql() {
        MysqlDataSource dataSource = null;
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(getUrl());
            dataSource.setUser("root");
            dataSource.setPassword("XXX");
            dataSource.setServerTimezone("UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    private String getUrl() {
        return "jdbc:mysql://IP:<puerto>/<database>" + "?allowPublicKeyRetrieval=true&useSSL=false";
    }
}
