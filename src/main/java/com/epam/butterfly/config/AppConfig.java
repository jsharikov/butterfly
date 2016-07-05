package com.epam.butterfly.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

/**
 * Application configuration.
 *
 * @author Artsiom_Buyevich
 */
@Configuration
@ComponentScan("com.epam.butterfly.service, com.epam.butterfly.handler")
@EnableJms
public class AppConfig {

   /* @Bean(name = "archiveService")
    public ArchiveService archiveService() {
        return new ArchiveServiceImpl();
    }*/

    @Bean(name = "connectionFactory")
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean(name = "queue")
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("archive.queue");
    }

    @Bean(name = "jmsTemplate")
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("5");
        return factory;
    }
}
