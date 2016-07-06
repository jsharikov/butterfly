package com.epam.butterfly.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Artsiom_Buyevich on 7/6/2016.
 */

public class UnFoundArchiveListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("UnFoundArchiveListener");
    }
}
