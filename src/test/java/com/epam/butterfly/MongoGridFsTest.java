package com.epam.butterfly;

import com.epam.butterfly.config.AppConfig;
import com.epam.butterfly.service.ArchiveService;
import com.mongodb.gridfs.GridFSDBFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

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
    @Autowired
    private GridFsOperations gridOperations;

    @Test
    public void testTemplate() throws IOException {
        //archiveService.save("test.zip");

        List<GridFSDBFile> result = gridOperations.find(
                new Query().addCriteria(Criteria.where("filename").is("100mb-4.txt")));

        for (GridFSDBFile file : result) {
            try {
                System.out.println(file.getFilename());
                System.out.println(file.getContentType());

                //save as another image
                file.writeTo("d:\\outbox\\100mb-4.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
