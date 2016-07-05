package com.epam.butterfly.handler;

import com.epam.butterfly.domain.NamedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Archive handler.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class ArchiveHandler {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination="archive.queue")
    public NamedEntity recieve(String archiveName) {
        System.out.println("Recieve: " + archiveName);
        NamedEntity namedEntity = new NamedEntity();
        namedEntity.setName(archiveName);
        return namedEntity;
    }
}
