package com.epam.butterfly;

import com.epam.butterfly.config.AppConfig;
import com.epam.butterfly.service.ArchiveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Mongo GridFS test.
 *
 * @author Artsiom_Buyevich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MongoGridFsTest {

    @Autowired
    private ArchiveService archiveService;

    @Test
    public void testTemplate() throws IOException {
        archiveService.save("test.zip");
    }

}
