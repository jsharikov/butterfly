package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;
import com.epam.butterfly.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;
import java.io.IOException;

/**
 * Archive service impliments.
 *
 * @author Artsiom_Buyevich
 */
@Service
@PropertySource("classpath:config.properties")
public class ArchiveServiceJmsTemplateImpl implements ArchiveService {

    @Value("${dir}")
    private String directory;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void ping() {
        System.out.println("ping");
    }

    @Override
    public void send(NamedEntity namedEntity) {
        System.out.println(namedEntity);
        jmsTemplate.send("archive.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(namedEntity.getName());
            }
        });
    }

    @Override
    public void save(String archiveName) throws IOException {
        if (directory != null || !directory.trim().isEmpty()) {
            ZipUtils.unzip(directory + archiveName, "D://outbox");
        }
    }

    @Override
    public boolean existArchive(String archiveName) {
        String fullPath = directory + archiveName;
        File file = new File(fullPath);
        return file.exists();
    }
}
