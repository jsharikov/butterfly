package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author Artsiom_Buyevich
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Destination destination;

    @Override
    public void ping() {

    }

    @Override
    public void send(NamedEntity namedEntity) {
        Connection conn = null;
        Session session = null;
        try {
            conn = connectionFactory.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();

            textMessage.setText(namedEntity.getName());
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(String archiveName) {

    }

    @Override
    public boolean existArchive(String archiveName) {
        return false;
    }
}
