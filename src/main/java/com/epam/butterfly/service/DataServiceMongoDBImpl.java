package com.epam.butterfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Data service impl.
 *
 * @author Artsiom_Buyevich
 */
@Service
public class DataServiceMongoDBImpl implements DataService {

    @Autowired
    private GridFsOperations gridOperations;

    @Override
    public void save(Path file) throws IOException {
        try (InputStream is = Files.newInputStream(file)) {
            String fileName = file.getFileName().toString();
            String contentType = Files.probeContentType(file);
            gridOperations.store(is, fileName, contentType);
        }
    }
}
