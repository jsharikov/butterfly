package com.epam.butterfly;

import com.epam.butterfly.config.AppConfig;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.dataformat.zipfile.ZipSplitter;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;

/**
 * Test camel.
 *
 * @author Artsiom_Buyevich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class CamelTest {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    public void test() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:D:\\inbox")
                        .split(new ZipSplitter())
                        .streaming()
                        .to("file:D:\\outbox");
            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }

}
