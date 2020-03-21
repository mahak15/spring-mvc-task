package com.configuration;


import com.dataobject.EmployeeDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:connection.properties")
public class WebConfig {

    private String PREFIX = "/WEB-INF/pages/";
    private String SUFFIX = ".jsp";

    @Value("${driver}")
    private String driverName;

    @Value("${url}")
    private String url;

    @Value("${user}")
    private String userName;

    @Value("${password}")
    private String password;


    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix(PREFIX);
        resolver.setSuffix(SUFFIX);

        return resolver;

    }

    @Bean
    public DriverManagerDataSource getDataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();


        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public EmployeeDao getEmployeeDAO() throws SQLException {
        return new EmployeeDao(getDataSource());
    }



}
