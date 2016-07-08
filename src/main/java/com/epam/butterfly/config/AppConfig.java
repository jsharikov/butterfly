package com.epam.butterfly.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Application configuration.
 *
 * @author Artsiom_Buyevich
 */
@Configuration
@ComponentScan("com.epam.butterfly")
@ImportResource("classpath:spring/camel-context.xml")
@PropertySource("classpath:config.properties")
public class AppConfig {

}
