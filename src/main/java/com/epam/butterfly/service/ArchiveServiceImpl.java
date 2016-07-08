package com.epam.butterfly.service;

import com.epam.butterfly.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Archive service implementation.
 *
 * @author Artsiom_Buyevich
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Value("${in.dir}")
    private String srcDirectory;
    @Value("${out.dir}")
    private String destDirectory;

    @Override
    public void save(String archiveName) throws IOException {
        if (srcDirectory != null || !srcDirectory.trim().isEmpty()) {
            ZipUtils.unzip(srcDirectory + archiveName, destDirectory);
        }
    }

}
