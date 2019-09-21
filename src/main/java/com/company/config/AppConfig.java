package com.company.config;


import com.company.controller.ControllerUtility;
import com.company.database.constants.DataBaseConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.company.service", "com.company.database"})
public class AppConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(DataBaseConstants.URL);
        dataSource.setUsername(DataBaseConstants.USER_NAME);
        dataSource.setPassword(DataBaseConstants.PASSWORD);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }

}