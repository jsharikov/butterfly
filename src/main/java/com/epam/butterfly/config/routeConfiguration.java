package com.epam.butterfly.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Camel configuration.
 *
 * @author Artsiom_Buyevich
 */
@Configuration
@ComponentScan("com.epam.butterfly.route")
public class RouteConfiguration extends CamelConfiguration {
}
