package com.epam.butterfly.route;

import com.epam.butterfly.service.ArchiveService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

/**
 * Created by Artsiom_Buyevich on 7/6/2016.
 */
@Component
public class TestRoute extends RouteBuilder {

    @Autowired
    @Qualifier("archiveServiceJmsTemplateImpl")
    private ArchiveService archiveService;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public void configure() throws Exception {
        from("jms:queue:archive.queue").choice()
                .when(bodyAs(String.class).isEqualTo("test777"))
                .to("jms:queue:archive.output.queue")
                .otherwise()
                .to("jms:topic:archive.not.found");
    }




}
