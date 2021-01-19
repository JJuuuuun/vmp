package com.toyproject.vending_machine.config;

import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
// spring boot 2.x.x 부터 기본 커넥션 풀 = Hikari Pool.
//https://bamdule.tistory.com/166
//https://bamdule.tistory.com/28

@Configuration
@MapperScan(basePackages = "com.toyproject.vending_machine.mapper")
@EnableTransactionManagement
public class MyBatisConfig {

    @Autowired
    private GlobalPropertiesConfig globalPropertiesConfig;

    @Bean
    @Primary
    public DataSource customDatasource() {
    // hikari pool setting > use properties
    // 별도로 설정하진 않았음
        return DataSourceBuilder
                .create()
                .driverClassName(globalPropertiesConfig.getDriverClassName())
                .url(globalPropertiesConfig.getUrl())
//                .url("jdbc:mysql://15.165.4.195:3306/vendingMachine?characterEncoding=UTF-8")
                .username(globalPropertiesConfig.getUsername())
                .password(globalPropertiesConfig.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(customDatasource());
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }


    //https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customDatasource());

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(resources);

        return sessionFactory.getObject();
    }
}
