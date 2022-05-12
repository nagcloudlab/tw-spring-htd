package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Profile("dev")
@Configuration
@PropertySource("classpath:datasource_dev.properties")
public class DataSourceDevConfiguration {

//    final Environment env;
//
//    public DataSourceConfiguration(Environment env) {
//        this.env = env;
//    }

    @Value("${datasource.driver}")
    private String driver;
    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.user}")
    private String user;
    @Value("${datasource.password}")
    private String password;

    @Value("#{systemProperties['user.country']}")
    private String country;

    @Value("#{db.platform}")
    private String dbType;


    @Bean
    @Description("Data-source for the underlying RDB we are using")
    public DataSource dataSource() {
        System.out.println(country);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }


}
