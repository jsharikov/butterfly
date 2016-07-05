package com.epam.butterfly.handler;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;

/**
 *
 *
 * @author Artsiom_Buyevich
 */
@MessageDriven(mappedName="jms/archive.queue")
public class ArchiveHandlerMDBImpl implements ArchiveHandler {

    @Resource
    private MessageDrivenContext mdc;

    @Override
    public void receive() {

    }
}
