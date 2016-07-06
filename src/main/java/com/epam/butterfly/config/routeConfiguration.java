package com.epam.butterfly.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Artsiom_Buyevich on 7/6/2016.
 */
@Configuration
@ComponentScan("com.epam.butterfly.route")
public class routeConfiguration extends CamelConfiguration {
}
