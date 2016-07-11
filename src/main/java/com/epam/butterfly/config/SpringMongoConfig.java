package com.epam.butterfly.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Mongo configuration.
 */
@Configuration
class SpringMongoConfig extends AbstractMongoConfiguration {

    private final static String DATABASE_NAME = "data";
    private final static String HOST = "127.0.0.1";

    @Bean
    public GridFsOperations getGridFsOperations() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(HOST);
    }

}
