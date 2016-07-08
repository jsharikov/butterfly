package com.epam.butterfly.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Archive helper.
 *
 * @author Artsiom_Buyevich
 */
@Component
public class ArchiveHelper {

    @Value("${in.dir}")
    private String srcDirectory;

    /**
     * Exist archive in the directory.
     *
     * @param archiveName name of archive
     * @return if exist, then true, else false
     */
    public boolean isExist(String archiveName) {
        String fullPath = srcDirectory + archiveName;
        Path path = Paths.get(fullPath);
        return Files.exists(path);
    }
}
