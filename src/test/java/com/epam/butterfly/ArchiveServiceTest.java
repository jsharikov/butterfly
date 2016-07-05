package com.epam.butterfly;

import com.epam.butterfly.config.AppConfig;
import com.epam.butterfly.domain.NamedEntity;
import com.epam.butterfly.handler.ArchiveHandler;
import com.epam.butterfly.service.ArchiveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Archive service test.
 *
 * @author Artsiom_Buyevich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ArchiveServiceTest {

    @Autowired
    @Qualifier("archiveServiceImpl")
    private ArchiveService archiveService;

    @Autowired
    private ArchiveHandler archiveHandler;

    @Test
    public void test() {
        final String MSG = "test archive";
        NamedEntity namedEntity = new NamedEntity();
        namedEntity.setName(MSG);
        archiveService.send(namedEntity);

        archiveHandler.receive();
        //Assert.assertEquals(MSG, namedEntity.getName());
    }
}
