package com.epam.butterfly.route;

import com.epam.butterfly.listener.UnFoundArchiveListener;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Subscriber when archive not found.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class UnFoundArchiveRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:topic:archive.not.found").bean(UnFoundArchiveListener.class);
    }
}
