package com.toyproject.vending_machine.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.toyproject.vending_machine.mapper")
@EnableTransactionManagement
public class MyBatisConfig {

    @Autowired
    private GlobalPropertiesConfig globalPropertiesConfig;

    @Bean
    @Primary
    public DataSource customDatasource() {
        return DataSourceBuilder
                .create()
                .url(globalPropertiesConfig.getUrl())
                .driverClassName(globalPropertiesConfig.getDriverClassName())
                .username(globalPropertiesConfig.getUsername())
                .password(globalPropertiesConfig.getPassword())
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource customDatasource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customDatasource);

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(resources);

        return sessionFactory.getObject();
    }
}
