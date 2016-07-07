package com.epam.butterfly;

import com.epam.butterfly.config.AppConfig;
import com.epam.butterfly.domain.NamedEntity;
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
    //@Qualifier("archiveServiceImpl")
    @Qualifier("archiveServiceJmsTemplateImpl")
    private ArchiveService archiveService;

    @Test
    public void test() throws InterruptedException {
        final String MSG = "test.zip";
        NamedEntity namedEntity = new NamedEntity();
        namedEntity.setName(MSG);
        archiveService.send(namedEntity);
    }
}
