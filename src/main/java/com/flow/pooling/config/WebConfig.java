package com.flow.pooling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by gy@fir.im on 24/04/2017.
 * Copyright @fir.im
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.flow.pooling.controller"})
@EnableMongoRepositories(value = "com.flow.pooling.dao")
@Import({MongoConfig.class, RedisConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String SPRING_ENV = "spring.profiles.active";
    private static final String POOLING_ENV = "flow.pooling.env";
    private static final String DEFAULT_ENV = "local";


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        String env = System.getProperty(SPRING_ENV);
        if (env == null) {
            env = System.getProperty(POOLING_ENV, DEFAULT_ENV);
        }

        String envPropertiesFile = String.format("app-%s.properties", env);
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource(envPropertiesFile));
        return configurer;
    }
}
