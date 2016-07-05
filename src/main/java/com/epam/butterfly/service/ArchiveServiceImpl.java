package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Archive service impliments.
 *
 * @author Artsiom_Buyevich
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void ping() {
        System.out.println("ping");
    }

    @Override
    public void send(NamedEntity namedEntity) {
        jmsTemplate.send("archive.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(namedEntity.getName());
            }
        });
    }
}
