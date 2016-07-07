package com.epam.butterfly.route;

import com.epam.butterfly.service.ArchiveService;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;


/**
 * Dispatcher route. If archive exist, then send into queue, else send to topic.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class MainRoute extends RouteBuilder {

    @Autowired
    @Qualifier("archiveServiceJmsTemplateImpl")
    private ArchiveService archiveService;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public void configure() throws Exception {

        Predicate predicate = new Predicate() {
            @Override
            public boolean matches(Exchange exchange) {
                Message message = exchange.getIn();
                String text = message.getBody(String.class);
                return archiveService.existArchive(text);
            }
        };
        from("jms:queue:archive.queue").choice()
                .when(predicate)
                .to("jms:queue:archive.output.queue")
                .otherwise()
                .to("jms:topic:archive.not.found");
    }
}
