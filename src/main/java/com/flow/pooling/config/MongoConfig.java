package com.flow.pooling.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by gy@fir.im on 26/04/2017.
 *
 * @Copyright fir.im
 */

@Configurable
public class MongoConfig {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private Integer port;

    @Value("${mongodb.db}")
    private String name;

    @Value("${mongodb.username}")
    private String username;

    @Value("${mongodb.password}")
    private String password;

    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        UserCredentials cert = new UserCredentials(username, password);
        return new MongoTemplate(mongo(), name, cert);
    }
}
