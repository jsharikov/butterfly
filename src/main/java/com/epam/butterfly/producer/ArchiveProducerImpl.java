package com.epam.butterfly.producer;

import com.epam.butterfly.domain.NamedEntity;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation archive producer.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class ArchiveProducerImpl implements ArchiveProducer {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public void send(NamedEntity namedEntity) {
        producerTemplate.sendBody("jms:queue:archive.queue", namedEntity.getName());
    }
}
