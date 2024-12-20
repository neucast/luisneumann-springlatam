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
            dataSource.setPassword("rootPswd-1");
            dataSource.setServerTimezone("UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    private String getUrl() {
        return "jdbc:mysql://172.17.0.2:3306/springlatam_labs" + "?allowPublicKeyRetrieval=true&useSSL=false";
    }
}
