package com.epam.butterfly.service;

import java.io.IOException;

/**
 * Archive service.
 *
 * @author Artsiom_Buyevich
 */
public interface ArchiveService {

    /**
     * Extract archive and save.
     *
     * @param archiveName name of archive
     * @throws IOException {@link IOException}
     */
    void save(String archiveName) throws IOException;

}
