package com.toyproject.vending_machine.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "file:/Users/jun/Desktop/vending_machine/local.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:/home/ubuntu/apps/vmp/etc/mysql.properties", ignoreResourceNotFound = true)
})
@Getter
public class GlobalPropertiesConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
