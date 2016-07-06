package com.epam.butterfly.route;

import com.epam.butterfly.listener.ArchiveListener;
import com.epam.butterfly.listener.UnFoundArchiveListener;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Archive route.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class ArchiveRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:archive.output.queue").bean(ArchiveListener.class);
    }
}
