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
 * Archive service implementation with JmsTemplate.
 *
 * @author Artsiom_Buyevich
 */
@Service
@PropertySource("classpath:config.properties")
public class ArchiveServiceJmsTemplateImpl implements ArchiveService {

    @Value("${in.dir}")
    private String srcDirectory;
    @Value("${out.dir}")
    private String destDirectory;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(NamedEntity namedEntity) {
        jmsTemplate.send("archive.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(namedEntity.getName());
            }
        });
    }

    @Override
    public void save(String archiveName) throws IOException {
        if (srcDirectory != null || !srcDirectory.trim().isEmpty()) {
            ZipUtils.unzip(srcDirectory + archiveName, destDirectory);
        }
    }

    @Override
    public boolean existArchive(String archiveName) {
        String fullPath = srcDirectory + archiveName;
        File file = new File(fullPath);
        return file.exists();
    }
}
