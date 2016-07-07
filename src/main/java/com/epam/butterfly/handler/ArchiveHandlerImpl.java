package com.epam.butterfly.handler;

import com.epam.butterfly.domain.NamedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Consumer queue implementation with core.
 *
 * @author Artsiom_Buyevich.
 */
@Component
public class ArchiveHandlerImpl  {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Destination destination;

    public void receive() {
        Connection conn = null;
        Session session = null;
        try {
            conn = connectionFactory.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;

            System.out.println("GOT A MESSAGE: " + textMessage.getText());
            conn.start();
        } catch (JMSException e) {
            //
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException ex) {

            }
        }
    }
}
