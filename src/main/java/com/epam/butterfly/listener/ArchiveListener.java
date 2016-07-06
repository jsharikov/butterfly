package com.epam.butterfly.listener;

import com.epam.butterfly.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Artsiom_Buyevich
 */
public class ArchiveListener implements MessageListener {

    @Autowired
    @Qualifier("archiveServiceJmsTemplateImpl")
    private ArchiveService archiveService;

    @Override
    public void onMessage(Message inMessage) {
        TextMessage msg = null;
        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                System.out.println("MESSAGE BEAN: Message received: " +
                        msg.getText());
                String archiveName = msg.getText();
                archiveService.save(archiveName);
            } else {
                System.out.println("Message of wrong type: " +
                        inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
