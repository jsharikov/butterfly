package com.epam.butterfly.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * Archive service implementation.
 *
 * @author Artsiom_Buyevich
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveServiceImpl.class);

    @Value("${in.dir}")
    private String srcDirectory;
    @Autowired
    private DataService dataService;

    @Override
    public void save(String archiveName) throws IOException {
        String fullFileName = srcDirectory + archiveName;
        try {
            Path path = Paths.get(fullFileName);

            try (FileSystem zipFileSystem = createZipFileSystem(path, false)){
                final Path root = zipFileSystem.getPath("/");

                Files.walkFileTree(root, new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        dataService.save(file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        } catch (InvalidPathException ex) {
            LOGGER.error(fullFileName + "not exist.", ex);
        }
    }

    private static FileSystem createZipFileSystem(Path path, boolean create) throws IOException {
        final URI uri = URI.create("jar:file:" + path.toUri().getPath());

        final Map<String, String> env = new HashMap<>();
        if (create) {
            env.put("create", "true");
        }
        return FileSystems.newFileSystem(uri, env);
    }
}
